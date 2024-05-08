//////////////////////////////////////////////////////////////////////
//
//    CodeGenVisitor - Walk the parser tree to do
//                     the generation of code
//
//    Copyright (C) 2020-2030  Universitat Politecnica de Catalunya
//
//    This library is free software; you can redistribute it and/or
//    modify it under the terms of the GNU General Public License
//    as published by the Free Software Foundation; either version 3
//    of the License, or (at your option) any later version.
//
//    This library is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//    Affero General Public License for more details.
//
//    You should have received a copy of the GNU Affero General Public
//    License along with this library; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//
//    contact: José Miguel Rivero (rivero@cs.upc.edu)
//             Computer Science Department
//             Universitat Politecnica de Catalunya
//             despatx Omega.110 - Campus Nord UPC
//             08034 Barcelona.  SPAIN
//
//////////////////////////////////////////////////////////////////////

#include "CodeGenVisitor.h"
#include "antlr4-runtime.h"

#include "../common/TypesMgr.h"
#include "../common/SymTable.h"
#include "../common/TreeDecoration.h"
#include "../common/code.h"

#include <string>
#include <cstddef>    // std::size_t

// uncomment the following line to enable debugging messages with DEBUG*
// #define DEBUG_BUILD
#include "../common/debug.h"

// using namespace std;


// Constructor
CodeGenVisitor::CodeGenVisitor(TypesMgr       & Types,
                               SymTable       & Symbols,
                               TreeDecoration & Decorations) :
  Types{Types},
  Symbols{Symbols},
  Decorations{Decorations} {
}

// Accessor/Mutator to the attribute currFunctionType
TypesMgr::TypeId CodeGenVisitor::getCurrentFunctionTy() const {
  return currFunctionType;
}

void CodeGenVisitor::setCurrentFunctionTy(TypesMgr::TypeId type) {
  currFunctionType = type;
}

// Methods to visit each kind of node:
//
antlrcpp::Any CodeGenVisitor::visitProgram(AslParser::ProgramContext *ctx) {
  DEBUG_ENTER();
  code my_code;
  SymTable::ScopeId sc = getScopeDecor(ctx);
  Symbols.pushThisScope(sc);
  for (auto ctxFunc : ctx->function()) { 
    subroutine subr = visit(ctxFunc);
    my_code.add_subroutine(subr);
  }
  Symbols.popScope();
  DEBUG_EXIT();
  return my_code;
}

antlrcpp::Any CodeGenVisitor::visitFunction(AslParser::FunctionContext *ctx) {
  DEBUG_ENTER();
  SymTable::ScopeId sc = getScopeDecor(ctx);
  Symbols.pushThisScope(sc);
  subroutine subr(ctx->ID()->getText());
  codeCounters.reset();
  setCurrentFunctionTy(Types.createVoidTy());



  if (ctx -> basic_type()) {
    TypesMgr::TypeId t1 = getTypeDecor(ctx -> basic_type());
    subr.add_param("_result", Types.to_string(t1));
    setCurrentFunctionTy(t1);
  }



  std::vector<var> && lparams = visit(ctx -> func_params());

  for (auto & oneparam: lparams) {
    bool array = oneparam.nelem != 1;
    subr.add_param(oneparam.name, oneparam.type, array);
  }
  std::vector<var> && lvars = visit(ctx->declarations());
  for (auto & onevar : lvars) {
    subr.add_var(onevar);
  }
  instructionList && code = visit(ctx->statements());

  code = code || instruction(instruction::RETURN());
  subr.set_instructions(code);
  Symbols.popScope();
  DEBUG_EXIT();
  return subr;
}

antlrcpp::Any CodeGenVisitor::visitReturnStmt(AslParser::ReturnStmtContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  if (ctx -> expr()) {
    CodeAttribs && codAtExpr = visit(ctx -> expr());
    TypesMgr::TypeId expressionType = getTypeDecor(ctx -> expr());
    TypesMgr::TypeId tRet = getCurrentFunctionTy();
    std::string addrExpr = codAtExpr.addr;
    instructionList & codeExpr = codAtExpr.code;
    code = code || codeExpr;

    
    if (Types.isFloatTy(tRet) and Types.isIntegerTy(expressionType)) {
      std::string tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::FLOAT(tempParam, addrExpr);
      addrExpr = tempParam;
    }
    
    code = code || instruction::LOAD("_result", addrExpr);
  }
  code = code || instruction::RETURN();
  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitFunc_params(AslParser::Func_paramsContext *ctx) {
  DEBUG_ENTER();
  std::vector<var> lvars;
  for (uint i = 0; i < ctx -> ID().size(); ++i) {
    TypesMgr::TypeId   t1 = getTypeDecor(ctx->type(i));
    if (Types.isArrayTy(t1)) {
      std::size_t      size = Types.getSizeOfType(t1);
      TypesMgr::TypeId t2 = Types.getArrayElemType(t1);
      lvars.push_back(var{ctx -> ID(i) ->getText(), Types.to_string(t2), size});
    }
    else lvars.push_back(var{ctx -> ID(i) -> getText(), Types.to_string(t1)});
  }
  DEBUG_EXIT();
  return lvars;
}

antlrcpp::Any CodeGenVisitor::visitFunctionCall(AslParser::FunctionCallContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  instructionList paramsPush;
  instructionList paramsPop;

  TypesMgr::TypeId functionType = Symbols.getType(ctx -> ident() -> getText());
	



  auto typesParams = Types.getFuncParamsTypes(functionType);

  for (uint i = 0; i < ctx -> expr().size(); ++i){
    CodeAttribs && codAtParam = visit(ctx -> expr(i));
    std::string addrParam = codAtParam.addr;
    instructionList & codeParam = codAtParam.code;


    code = code || codeParam;
    std:: string tempParam = addrParam;
    TypesMgr::TypeId tParam = getTypeDecor(ctx -> expr(i));

    if (Types.isFloatTy(typesParams[i]) and Types.isIntegerTy(tParam)) {
      tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::FLOAT(tempParam, addrParam);
    }
    else if (Types.isArrayTy(tParam) and Symbols.isLocalVarClass(tempParam)) {
      tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::ALOAD(tempParam,addrParam);
    }

    paramsPush = paramsPush || instruction::PUSH(tempParam);
    paramsPop = paramsPop || instruction::POP();

  }

  code = code || instruction::PUSH() || paramsPush;
  code = code || instruction::CALL(ctx -> ident() -> getText());
  std::string temp = "%" + codeCounters.newTEMP();
  code = code || paramsPop || instruction::POP(temp);

  CodeAttribs codAts(temp, "", code);

  DEBUG_EXIT();
  return codAts;
}

antlrcpp::Any CodeGenVisitor::visitDeclarations(AslParser::DeclarationsContext *ctx) {
  DEBUG_ENTER();
  std::vector<var> lvars;
  for (auto & varDeclCtx : ctx->variable_decl()) {
    std::vector<var> onevar = visit(varDeclCtx);
    for (uint i = 0; i < onevar.size(); ++i) {
      lvars.push_back(onevar[i]);
    }
  }
  DEBUG_EXIT();
  return lvars;
}

antlrcpp::Any CodeGenVisitor::visitVariable_decl(AslParser::Variable_declContext *ctx) {
  DEBUG_ENTER();
  std::vector<var> lvars;
  TypesMgr::TypeId   t1 = getTypeDecor(ctx->type());
  std::size_t      size = Types.getSizeOfType(t1);
  for (auto varID : ctx->ID()) {
    if (Types.isArrayTy(t1)) {
      TypesMgr::TypeId t2 = Types.getArrayElemType(t1);
      lvars.push_back(var{varID->getText(), Types.to_string(t2), size});
    }
    else lvars.push_back(var{varID->getText(), Types.to_string(t1), size});
  }
  DEBUG_EXIT();
  return lvars;
}

antlrcpp::Any CodeGenVisitor::visitArrayElement(AslParser::ArrayElementContext *ctx) {
  DEBUG_ENTER();

  CodeAttribs && codAtIdent = visit(ctx->ident());
  std::string addrIdent = codAtIdent.addr;
  instructionList & codeIdent = codAtIdent.code;

  CodeAttribs && codAtExpr = visit(ctx->expr());
  std::string addrExpr = codAtExpr.addr;
  instructionList & codeExpr = codAtExpr.code;

  instructionList code = codeIdent || codeExpr;

  std::string temp = "%" + codeCounters.newTEMP();
  code = code || instruction::LOADX(temp, addrIdent, addrExpr);

  CodeAttribs codAts(temp, "", code);

  DEBUG_EXIT();
  return codAts;
}


antlrcpp::Any CodeGenVisitor::visitStatements(AslParser::StatementsContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  for (auto stCtx : ctx->statement()) {
    instructionList && codeS = visit(stCtx);
    code = code || codeS;
  }
  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitAssignStmt(AslParser::AssignStmtContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAtsE1 = visit(ctx->left_expr());
  std::string           addr1 = codAtsE1.addr;
  std::string           offs1 = codAtsE1.offs;
  instructionList &     code1 = codAtsE1.code;
  TypesMgr::TypeId tid1 = getTypeDecor(ctx->left_expr());
  
  CodeAttribs     && codAtsE2 = visit(ctx->expr());
  std::string           addr2 = codAtsE2.addr;
  std::string           offs2 = codAtsE2.offs;
  instructionList &     code2 = codAtsE2.code;
  TypesMgr::TypeId tid2 = getTypeDecor(ctx->expr());

  instructionList code = code1 || code2;

  bool isArrayAccessLeftExpr = ctx->left_expr()->expr() != NULL;

  // case of copying array to array i.e. a=b
  if (Types.isArrayTy(tid1) and Types.isArrayTy(tid2)) {
    unsigned int arraySize = Types.getArraySize(tid2);
    unsigned int sizeElemT1 = Types.getSizeOfType(Types.getArrayElemType(tid1));
    unsigned int sizeElemT2 = Types.getSizeOfType(Types.getArrayElemType(tid2));

    std::string sizeElem2 = "%" + codeCounters.newTEMP();
    std::string sizeElem1 = "%" + codeCounters.newTEMP();
    std::string tempElem2 = "%" + codeCounters.newTEMP();
    std::string offset1Bytes = "%" + codeCounters.newTEMP();
    std::string label = codeCounters.newLabelWHILE();
    std::string labelWhile = "while" + label;
    std::string labelEndWhile = "endwhile" + label;

    std::string tempIndex = "%" + codeCounters.newTEMP();
    std::string tempVal = "%" + codeCounters.newTEMP();
    std::string condition = "%" + codeCounters.newTEMP();

    // while i < arraySize a[i]=b[i]
    code = code || instruction::ILOAD(tempIndex,"0") || instruction::LABEL(labelWhile) || instruction::ILOAD(tempVal,std::to_string(arraySize)) 
                || instruction::LT(condition,tempIndex,tempVal) || instruction::FJUMP(condition,labelEndWhile) 
                || instruction::ILOAD(sizeElem2,std::to_string(sizeElemT2)) || instruction::MUL(tempElem2,tempIndex,sizeElem2)
                || instruction::LOADX(tempElem2,addr2,tempElem2) || instruction::ILOAD(sizeElem1,std::to_string(sizeElemT1))
                || instruction::MUL(offset1Bytes,tempIndex,sizeElem1) || instruction::XLOAD(addr1,offset1Bytes,tempElem2) || instruction::ILOAD(tempVal,"1")
                || instruction::ADD(tempIndex,tempIndex,tempVal) || instruction::UJUMP(labelWhile) || instruction::LABEL(labelEndWhile);
  }
  else {
    if (Types.isFloatTy(tid1) and Types.isIntegerTy(tid2)) {
      std::string tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::FLOAT(tempParam, addr2);
      addr2 = tempParam;
    }
    if (isArrayAccessLeftExpr) {
      unsigned int sizeElemT1 = Types.getSizeOfType(tid1);
      std::string t1offset = "%" + codeCounters.newTEMP();
      std::string sizeElemT1Temp = "%" + codeCounters.newTEMP();

      code = code || instruction::ILOAD(sizeElemT1Temp,std::to_string(sizeElemT1)) || instruction::MUL(t1offset,offs1,sizeElemT1Temp) || instruction::XLOAD(addr1,t1offset,addr2);
    }
    else  {
      code = code || instruction::LOAD(addr1, addr2);
    }
  } 

  
  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitIfStmt(AslParser::IfStmtContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  CodeAttribs     && codAtsE = visit(ctx->expr());
  std::string          addr1 = codAtsE.addr;          //address if(expr)
  instructionList &    code1 = codAtsE.code;          //code of if(expr)
  instructionList &&   code2 = visit(ctx->statements(0));  //code statements of then
  std::string label = codeCounters.newLabelIF();
  std::string labelEndIf = "endif"+label;

  if (ctx->ELSE()) {
    instructionList &&   code3 = visit(ctx->statements(1));
    std::string labelElse = "else"+label;
    code = code1 || instruction::FJUMP(addr1, labelElse) ||
         code2 || instruction::UJUMP(labelEndIf) || instruction::LABEL(labelElse) || code3 || instruction::LABEL(labelEndIf);
  }

  else {
  code = code1 || instruction::FJUMP(addr1, labelEndIf) ||
         code2 || instruction::LABEL(labelEndIf);
  }

  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitWhileStmt(AslParser::WhileStmtContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs && codAtsE = visit(ctx->expr());
  std::string          addrCond = codAtsE.addr;          //address of while condition
  instructionList &    codeCond = codAtsE.code;          //code of while condition
  instructionList && stmtsCode = visit(ctx->statements()); //do statements code

  std::string label = codeCounters.newLabelWHILE();
  std::string labelWhile = "while" + label;
  std::string labelEndWhile = "endwhile" + label;

  instructionList && code = instruction::LABEL(labelWhile) || codeCond || instruction::FJUMP(addrCond,labelEndWhile) 
                            || stmtsCode || instruction::UJUMP(labelWhile) || instruction::LABEL(labelEndWhile);

  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitProcCall(AslParser::ProcCallContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  instructionList paramsPush;
  instructionList paramsPop;

  TypesMgr::TypeId tFunc= Symbols.getType(ctx -> ident() -> getText());;
  TypesMgr::TypeId tRet = Types.getFuncReturnType(tFunc);

  auto typesParams = Types.getFuncParamsTypes(getTypeDecor(ctx -> ident()));

  for (uint i = 0; i < ctx -> expr().size(); ++i){
    CodeAttribs && codAtParam = visit(ctx -> expr(i));
    std::string addrParam = codAtParam.addr;
    instructionList & codeParam = codAtParam.code;

    code = code || codeParam;
    std:: string tempParam = addrParam;
    TypesMgr::TypeId tParam = getTypeDecor(ctx -> expr(i));

    if (Types.isFloatTy(typesParams[i]) and Types.isIntegerTy(tParam)) {
      tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::FLOAT(tempParam, addrParam);
    }
    else if (Types.isArrayTy(tParam) and Symbols.isLocalVarClass(tempParam)) {
      tempParam = "%" + codeCounters.newTEMP();
      code = code || instruction::ALOAD(tempParam,addrParam);
    }

    paramsPush = paramsPush || instruction::PUSH(tempParam);
    paramsPop = paramsPop || instruction::POP();

  }
  if (not Types.isVoidTy(tRet)) {
    paramsPush = instruction::PUSH() || paramsPush;
    paramsPop = paramsPop || instruction::POP();
  }

  code = code || paramsPush;
  code = code || instruction::CALL(ctx -> ident() -> getText());
  code = code || paramsPop;

  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitReadStmt(AslParser::ReadStmtContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAtsE = visit(ctx->left_expr());
  std::string          addr1 = codAtsE.addr;
  std::string          offset1 = codAtsE.offs;
  instructionList &    code1 = codAtsE.code;
  instructionList &     code = code1;
  TypesMgr::TypeId tid1 = getTypeDecor(ctx->left_expr());


  bool isArray = ctx -> left_expr() -> expr();
  std:: string temp = isArray ? "%" + codeCounters.newTEMP() : addr1;
  // read of an array access
  
  if (Types.isIntegerTy(tid1) or Types.isBooleanTy(tid1)) code = code1 || instruction::READI(temp);
  else if (Types.isFloatTy(tid1)) code = code1 || instruction::READF(temp);
  else code = code1 || instruction::READC(temp);

  if (isArray) {
    unsigned int arrayElemSize = Types.getSizeOfType(tid1);
    std::string temp1 = "%" + codeCounters.newTEMP();
    code = code || instruction::ILOAD(temp1,std::to_string(arrayElemSize)) || instruction::MUL(temp1,offset1,temp1) || instruction::XLOAD(addr1,offset1,temp);
    addr1 = temp1;
  }
  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitWriteExpr(AslParser::WriteExprContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAt1 = visit(ctx->expr());
  std::string         addr1 = codAt1.addr;
  std::string         offset1 = codAt1.offs;
  instructionList &   code1 = codAt1.code;
  instructionList &    code = code1;
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr());

  if (Types.isFloatTy(t1)) code = code || instruction::WRITEF(addr1);
  else if (Types.isIntegerTy(t1) or Types.isBooleanTy(t1)) code = code || instruction::WRITEI(addr1);
  // character
  else code = code || instruction::WRITEC(addr1);

  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitWriteString(AslParser::WriteStringContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  std::string s = ctx->STRING()->getText();
  code = code || instruction::WRITES(s);
  DEBUG_EXIT();
  return code;
}

antlrcpp::Any CodeGenVisitor::visitLeft_expr(AslParser::Left_exprContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs && codAts = visit(ctx->ident());

  // Left_expr is an array
  if (ctx->expr()) {
    CodeAttribs && codAtsExpr = visit(ctx->expr());
    codAts.offs = codAtsExpr.addr;
    codAts.code = codAts.code || codAtsExpr.code;
  }

  DEBUG_EXIT();
  return codAts;
}

antlrcpp::Any CodeGenVisitor::visitArithmetic(AslParser::ArithmeticContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAt1 = visit(ctx->expr(0));
  std::string         addr1 = codAt1.addr;
  std::string         offset1 = codAt1.offs;
  instructionList &   code1 = codAt1.code;
  
  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  // TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  // TypesMgr::TypeId  t = getTypeDecor(ctx);
  std::string temp = "%"+codeCounters.newTEMP();

  
  if (ctx -> expr(1)) {
    CodeAttribs     && codAt2 = visit(ctx->expr(1));
    std::string         addr2 = codAt2.addr;
    std::string         offset2 = codAt2.offs;
    instructionList &   code2 = codAt2.code;
    instructionList &&   code = code1 || code2;
    TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));

    if (Types.isFloatTy(t1) || Types.isFloatTy(t2)) {
      if (not Types.isFloatTy(t1)) addr1 = coerceTypes(code,t1,t2,addr1);
      if (not Types.isFloatTy(t2)) addr2 = coerceTypes(code,t2,t1,addr2);
      if (ctx->MUL()) {
        code = code || instruction::FMUL(temp, addr1, addr2);
      }
      else if (ctx -> MINUS()) {
        code = code || instruction::FSUB(temp, addr1, addr2);
      }
      else if (ctx -> DIV()) {
        code = code || instruction::FDIV(temp, addr1, addr2);
      }
      else {
        code = code || instruction::FADD(temp, addr1, addr2);
      }
    }
    else {
      if (ctx->MUL()) {
        code = code || instruction::MUL(temp, addr1, addr2);
      }
      else if (ctx -> MINUS()) {
        code = code || instruction::SUB(temp, addr1, addr2);
      }
      else if (ctx -> DIV()) {
        code = code || instruction::DIV(temp, addr1, addr2);
      }
      else if (ctx -> MOD()) {
        code = code || instruction::DIV(temp, addr1, addr2) || instruction::MUL(temp, addr2, temp) || instruction::SUB(temp, addr1, temp);
      }
      else {
        code = code || instruction::ADD(temp, addr1, addr2);
      }
    }
    CodeAttribs codAts(temp, "", code);
    DEBUG_EXIT();
    return codAts;
  }
  else {
    if (ctx -> PLUS()) {
      instructionList &&  code = code1 || instruction::LOAD(temp, addr1);
      CodeAttribs codAts(temp, "", code);
      DEBUG_EXIT();
      return codAts;
    }
    else if (ctx -> MINUS()) {
      if (Types.isFloatTy(t1)){
        instructionList &&  code = code1 || instruction::FNEG(temp, addr1);
        CodeAttribs codAts(temp, "", code);
        DEBUG_EXIT();
        return codAts;
      }
      else {
        instructionList &&  code = code1 || instruction::NEG(temp, addr1);
        CodeAttribs codAts(temp, "", code);
        DEBUG_EXIT();
        return codAts;
      }
    }
  }
}

antlrcpp::Any CodeGenVisitor::visitRelational(AslParser::RelationalContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAt1 = visit(ctx->expr(0));
  std::string         addr1 = codAt1.addr;
  std::string         offset1 = codAt1.offs;
  instructionList &   code1 = codAt1.code;

  CodeAttribs     && codAt2 = visit(ctx->expr(1));
  std::string         addr2 = codAt2.addr;
  std::string         offset2 = codAt2.offs;
  instructionList &   code2 = codAt2.code;

  instructionList &&   code = code1 || code2;

  // TypesMgr::TypeId  t = getTypeDecor(ctx);
  std::string temp = "%"+codeCounters.newTEMP();
  std::string temp1 = "%"+codeCounters.newTEMP();

  TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));


  if (Types.isFloatTy(t1) or Types.isFloatTy(t2)) {
    if (not Types.isFloatTy(t1)) addr1 = coerceTypes(code,t1,t2,addr1);
    if (not Types.isFloatTy(t2)) addr2 = coerceTypes(code,t2,t1,addr2);

    if (ctx -> EQUAL()) code = code || instruction::FEQ(temp, addr1, addr2);
    else if (ctx -> NEQ()) code = code || instruction::FLT(temp, addr1, addr2) || instruction::FLT(temp1, addr2, addr1) || instruction::OR(temp, temp, temp1);
    else if (ctx -> G()) code = code || instruction::FLT(temp, addr2, addr1);
    else if (ctx -> L()) code = code || instruction::FLT(temp, addr1, addr2);
    else if (ctx -> GE()) code = code || instruction::FLE(temp, addr2, addr1);
    else code = code || instruction::LE(temp, addr1, addr2);
  }

  else {
    if (ctx -> EQUAL()) code = code || instruction::EQ(temp, addr1, addr2);
    else if (ctx -> NEQ()) code = code || instruction::LT(temp, addr1, addr2) || instruction::LT(temp1, addr2, addr1) || instruction::OR(temp, temp, temp1);
    else if (ctx -> G()) code = code || instruction::LT(temp, addr2, addr1);
    else if (ctx -> L()) code = code || instruction::LT(temp, addr1, addr2);
    else if (ctx -> GE()) code = code || instruction::LE(temp, addr2, addr1);
    else code = code || instruction::LE(temp, addr1, addr2);
  }

  CodeAttribs codAts(temp, "", code);
  DEBUG_EXIT();
  return codAts;
}

antlrcpp::Any CodeGenVisitor::visitLogical(AslParser::LogicalContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs     && codAt1 = visit(ctx->expr(0));
  std::string         addr1 = codAt1.addr;
  instructionList &   code1 = codAt1.code;
  /*
  CodeAttribs     && codAt2 = visit(ctx->expr(1));
  std::string         addr2 = codAt2.addr;
  instructionList &   code2 = codAt2.code;
  */
   //|| code2;
  // TypesMgr::TypeId t1 = getTypeDecor(ctx->expr(0));
  // TypesMgr::TypeId t2 = getTypeDecor(ctx->expr(1));
  // TypesMgr::TypeId  t = getTypeDecor(ctx);
  std::string temp = "%"+codeCounters.newTEMP();

  if (ctx -> expr(1)) {
    CodeAttribs     && codAt2 = visit(ctx->expr(1));
    std::string         addr2 = codAt2.addr;
    instructionList &   code2 = codAt2.code;
    instructionList &&   code = code1 || code2;

    if (ctx->AND()) code = code || instruction::AND(temp, addr1, addr2);
    else code = code || instruction::OR(temp, addr1, addr2);
    CodeAttribs codAts(temp, "", code);
     DEBUG_EXIT();
    return codAts;
  }
  else {
    instructionList &&   code = code1 || instruction::NOT(temp, addr1);
    CodeAttribs codAts(temp, "", code);
     DEBUG_EXIT();
    return codAts;
  }


}

antlrcpp::Any CodeGenVisitor::visitValue(AslParser::ValueContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  const std::string & value = ctx->getText();

  std::string temp = "%"+codeCounters.newTEMP();

  if (ctx -> FLOATVAL()) {
    code = instruction::FLOAD(temp,value);
  }
  else if (ctx -> INTVAL()) {
    code = instruction::ILOAD(temp,value);
  }
  else if (ctx -> BOOLVAL()) {
    if (value == "true") code = instruction::ILOAD(temp,"1");
    else code = instruction::ILOAD(temp,"0");
  }
  // character
  else {
    code = instruction::CHLOAD(temp,value.substr(1,value.size()-2));
  }
  
  CodeAttribs codAts(temp, "", code);
  DEBUG_EXIT();
  return codAts;
}

antlrcpp::Any CodeGenVisitor::visitExprIdent(AslParser::ExprIdentContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs && codAts = visit(ctx->ident());
  DEBUG_EXIT();
  return codAts;
}

antlrcpp::Any CodeGenVisitor::visitIdent(AslParser::IdentContext *ctx) {
  DEBUG_ENTER();
  instructionList code;
  std::string name = ctx -> ID() -> getText();
  TypesMgr::TypeId type = Symbols.getType(name);
  if (Symbols.isParameterClass(name) and Types.isArrayTy(type)) {
    std::string address = "%" + codeCounters.newTEMP();
    code = code || instruction::LOAD(address, name);
    name = address;
  }
  CodeAttribs codAts(name, "", code);
  DEBUG_EXIT();
  return codAts;
}

std::string CodeGenVisitor::coerceTypes(instructionList & code, TypesMgr::TypeId t1, TypesMgr::TypeId t2, std::string t1Addr) {
  if (Types.isFloatTy(t1) || Types.isFloatTy(t2)) {
    std::string temp = "%" + codeCounters.newTEMP();
    code = code || instruction::FLOAT(temp,t1Addr);
    return temp;
  }
  else return t1Addr;
}

antlrcpp::Any CodeGenVisitor::visitNone(AslParser::NoneContext *ctx) {
  DEBUG_ENTER();
  CodeAttribs && codAts = visit(ctx->expr());
  DEBUG_EXIT();
  return codAts;
}

TypesMgr::TypeId CodeGenVisitor::stringToTypeId(std::string type) {
  if (type == "integer") return Types.createIntegerTy();
  else if (type == "bool") return Types.createBooleanTy();
  else if (type == "float") return Types.createFloatTy();
  else if (type == "character") return Types.createCharacterTy();
  else if (type == "bool") return Types.createBooleanTy();
  else if (type == "error") return Types.createErrorTy();
  else return Types.createArrayTy(0, Types.createIntegerTy());
}


// Getters for the necessary tree node atributes:
//   Scope and Type
SymTable::ScopeId CodeGenVisitor::getScopeDecor(antlr4::ParserRuleContext *ctx) const {
  return Decorations.getScope(ctx);
}
TypesMgr::TypeId CodeGenVisitor::getTypeDecor(antlr4::ParserRuleContext *ctx) const {
  return Decorations.getType(ctx);
}


// Constructors of the class CodeAttribs:
//
CodeGenVisitor::CodeAttribs::CodeAttribs(const std::string & addr,
                                         const std::string & offs,
                                         instructionList & code) :
  addr{addr}, offs{offs}, code{code} {
}

CodeGenVisitor::CodeAttribs::CodeAttribs(const std::string & addr,
                                         const std::string & offs,
                                         instructionList && code) :
  addr{addr}, offs{offs}, code{code} {
}
