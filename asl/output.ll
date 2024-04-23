
@.str.i = constant [3 x i8] c"%d\00"
@.str.s.1 = constant [9 x i8] c"n >= 0!\0A\00"
@.str.s.2 = constant [3 x i8] c"!=\00"
@.str.s.3 = constant [2 x i8] c"\0A\00"




define dso_local i32 @main() {
  .entry:
    %n.addr = alloca i32
    %f.addr = alloca i32
    %aux.addr = alloca i32
    %end.addr = alloca i1
    call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32* %n.addr)
    %n.1 = load i32, i32* %n.addr
    store i32 %n.1, i32* %aux.addr
    %.temp.1 = trunc i64 0 to i32
    %n.2 = load i32, i32* %n.addr
    %.temp.2 = icmp slt i32 %n.2, %.temp.1
    br i1 %.temp.2, label %.br.cont.1, label %endif1
  .br.cont.1:
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([9 x i8], [9 x i8]* @.str.s.1, i64 0, i64 0))
    %.temp.4 = trunc i64 1 to i1
    store i1 %.temp.4, i1* %end.addr
    br label %endif1
  endif1:
    %.temp.5 = trunc i64 1 to i32
    store i32 %.temp.5, i32* %f.addr
    br label %while1
  while1:
    %end.1 = load i1, i1* %end.addr
    %.temp.6 = xor i1 %end.1, 1
    %.temp.8 = trunc i64 1 to i32
    %n.3 = load i32, i32* %n.addr
    %.temp.9 = icmp slt i32 %.temp.8, %n.3
    %.temp.7 = and i1 %.temp.6, %.temp.9
    br i1 %.temp.7, label %.br.cont.2, label %endwhile1
  .br.cont.2:
    %f.1 = load i32, i32* %f.addr
    %n.4 = load i32, i32* %n.addr
    %.temp.11 = mul i32 %f.1, %n.4
    store i32 %.temp.11, i32* %f.addr
    %.temp.13 = trunc i64 1 to i32
    %n.5 = load i32, i32* %n.addr
    %.temp.12 = sub i32 %n.5, %.temp.13
    store i32 %.temp.12, i32* %n.addr
    br label %while1
  endwhile1:
    %.temp.14 = trunc i64 0 to i1
    %end.2 = load i1, i1* %end.addr
    %.temp.15 = icmp eq i1 %end.2, %.temp.14
    br i1 %.temp.15, label %.br.cont.3, label %endif2
  .br.cont.3:
    %aux.1 = load i32, i32* %aux.addr
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %aux.1)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.s.2, i64 0, i64 0))
    %f.2 = load i32, i32* %f.addr
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %f.2)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.s.3, i64 0, i64 0))
    br label %endif2
  endif2:
    ret i32 0
}


declare dso_local i32 @printf(i8*, ...)
declare dso_local i32 @__isoc99_scanf(i8*, ...)


