
@.str.i = constant [3 x i8] c"%d\00"
@.str.s.1 = constant [7 x i8] c"err!!\0A\00"
@.str.s.2 = constant [2 x i8] c"\0A\00"




define dso_local void @f1() {
  .entry:
    %x1.addr = alloca i32
    %y1.addr = alloca i32
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([7 x i8], [7 x i8]* @.str.s.1, i64 0, i64 0))
    %.temp.1 = trunc i64 2 to i32
    %y1.1 = load i32, i32* %y1.addr
    %.temp.2 = mul i32 %y1.1, %.temp.1
    %x1.1 = load i32, i32* %x1.addr
    %.temp.3 = icmp eq i32 %x1.1, %.temp.2
    br i1 %.temp.3, label %.br.cont.1, label %endif1
  .br.cont.1:
    %.temp.4 = trunc i64 3 to i32
    %y1.2 = load i32, i32* %y1.addr
    %.temp.5 = add i32 %y1.2, %.temp.4
    store i32 %.temp.5, i32* %x1.addr
    %y1.3 = load i32, i32* %y1.addr
    %x1.2 = load i32, i32* %x1.addr
    %.temp.6 = mul i32 %y1.3, %x1.2
    %x1.3 = load i32, i32* %x1.addr
    %.temp.7 = add i32 %x1.3, %.temp.6
    store i32 %.temp.7, i32* %y1.addr
    br label %endif1
  endif1:
    ret void
}

define dso_local i32 @main() {
  .entry:
    %x1.addr = alloca i32
    %.temp.1 = trunc i64 0 to i32
    store i32 %.temp.1, i32* %x1.addr
    %.temp.2 = trunc i64 1 to i32
    %x1.1 = load i32, i32* %x1.addr
    %.temp.3 = icmp eq i32 %x1.1, %.temp.2
    br i1 %.temp.3, label %.br.cont.1, label %endif1
  .br.cont.1:
    call void @f1()
    br label %endif1
  endif1:
    %.temp.4 = trunc i64 4 to i32
    %.temp.5 = trunc i64 5 to i32
    %.temp.6 = mul i32 %.temp.4, %.temp.5
    %.temp.7 = trunc i64 6 to i32
    %.temp.8 = add i32 %.temp.6, %.temp.7
    store i32 %.temp.8, i32* %x1.addr
    %x1.2 = load i32, i32* %x1.addr
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %x1.2)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.s.2, i64 0, i64 0))
    ret i32 0
}


declare dso_local i32 @printf(i8*, ...)


