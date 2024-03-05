
// Generated from Asl.g4 by ANTLR 4.7.2

#pragma once


#include "antlr4-runtime.h"




class  AslLexer : public antlr4::Lexer {
public:
  enum {
    T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, EQUAL = 5, NEQ = 6, G = 7, L = 8, 
    GE = 9, LE = 10, ASSIGN = 11, PLUS = 12, MINUS = 13, MUL = 14, DIV = 15, 
    AND = 16, OR = 17, VAR = 18, INT = 19, FLOAT = 20, CHAR = 21, BOOL = 22, 
    IF = 23, THEN = 24, ELSE = 25, ENDIF = 26, FUNC = 27, ENDFUNC = 28, 
    READ = 29, WRITE = 30, ARRAY = 31, LSBRACKET = 32, RSBRACKET = 33, OF = 34, 
    INTVAL = 35, FLOATVAL = 36, CHARVAL = 37, BOOLVAL = 38, COMMA = 39, 
    ID = 40, STRING = 41, COMMENT = 42, WS = 43
  };

  AslLexer(antlr4::CharStream *input);
  ~AslLexer();

  virtual std::string getGrammarFileName() const override;
  virtual const std::vector<std::string>& getRuleNames() const override;

  virtual const std::vector<std::string>& getChannelNames() const override;
  virtual const std::vector<std::string>& getModeNames() const override;
  virtual const std::vector<std::string>& getTokenNames() const override; // deprecated, use vocabulary instead
  virtual antlr4::dfa::Vocabulary& getVocabulary() const override;

  virtual const std::vector<uint16_t> getSerializedATN() const override;
  virtual const antlr4::atn::ATN& getATN() const override;

private:
  static std::vector<antlr4::dfa::DFA> _decisionToDFA;
  static antlr4::atn::PredictionContextCache _sharedContextCache;
  static std::vector<std::string> _ruleNames;
  static std::vector<std::string> _tokenNames;
  static std::vector<std::string> _channelNames;
  static std::vector<std::string> _modeNames;

  static std::vector<std::string> _literalNames;
  static std::vector<std::string> _symbolicNames;
  static antlr4::dfa::Vocabulary _vocabulary;
  static antlr4::atn::ATN _atn;
  static std::vector<uint16_t> _serializedATN;


  // Individual action functions triggered by action() above.

  // Individual semantic predicate functions triggered by sempred() above.

  struct Initializer {
    Initializer();
  };
  static Initializer _init;
};

