
@.str.i = constant [3 x i8] c"%d\00"
@.str.s.1 = constant [3 x i8] c"ok\00"
@.str.s.2 = constant [5 x i8] c"bye\0A\00"




define dso_local void @f2() {
  .entry:
    %x2.addr = alloca i32
    %y2.addr = alloca i32
    %.temp.1 = trunc i64 0 to i32
    store i32 %.temp.1, i32* %x2.addr
    %x2.1 = load i32, i32* %x2.addr
    store i32 %x2.1, i32* %y2.addr
    %.temp.3 = trunc i64 3 to i32
    %y2.1 = load i32, i32* %y2.addr
    %.temp.2 = mul i32 %y2.1, %.temp.3
    %x2.2 = load i32, i32* %x2.addr
    %.temp.4 = icmp eq i32 %x2.2, %.temp.2
    br i1 %.temp.4, label %.br.cont.1, label %endif3
  .br.cont.1:
    %.temp.7 = trunc i64 5 to i32
    %y2.2 = load i32, i32* %y2.addr
    %.temp.6 = mul i32 %y2.2, %.temp.7
    %.temp.9 = trunc i64 3 to i32
    %.temp.8 = add i32 %.temp.6, %.temp.9
    store i32 %.temp.8, i32* %x2.addr
    %.temp.10 = trunc i64 1 to i32
    %y2.3 = load i32, i32* %y2.addr
    %.temp.11 = add i32 %.temp.10, %y2.3
    %.temp.13 = trunc i64 1 to i32
    %.temp.12 = add i32 %.temp.11, %.temp.13
    store i32 %.temp.12, i32* %y2.addr
    %.temp.15 = trunc i64 1 to i32
    %x2.3 = load i32, i32* %x2.addr
    %.temp.14 = add i32 %x2.3, %.temp.15
    %.temp.17 = trunc i64 2 to i32
    %y2.4 = load i32, i32* %y2.addr
    %.temp.16 = mul i32 %y2.4, %.temp.17
    %.temp.18 = icmp eq i32 %.temp.14, %.temp.16
    br i1 %.temp.18, label %.br.cont.2, label %endif1
  .br.cont.2:
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.s.1, i64 0, i64 0))
    br label %endif1
  endif1:
    %.temp.20 = trunc i64 1 to i32
    %.temp.22 = trunc i64 1 to i32
    %.temp.21 = add i32 %.temp.20, %.temp.22
    %y2.5 = load i32, i32* %y2.addr
    %.temp.23 = icmp eq i32 %y2.5, %.temp.21
    br i1 %.temp.23, label %.br.cont.3, label %endif2
  .br.cont.3:
    %.temp.26 = trunc i64 6 to i32
    %x2.4 = load i32, i32* %x2.addr
    %.temp.25 = mul i32 %x2.4, %.temp.26
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %.temp.25)
    br label %endif2
  endif2:
    br label %endif3
  endif3:
    ret void
}

define dso_local i32 @main() {
  .entry:
    %.temp.1 = trunc i64 7 to i32
    %.temp.2 = trunc i64 7 to i32
    %.temp.3 = icmp eq i32 %.temp.1, %.temp.2
    br i1 %.temp.3, label %.br.cont.1, label %endif1
  .br.cont.1:
    call void @f2()
    br label %endif1
  endif1:
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([5 x i8], [5 x i8]* @.str.s.2, i64 0, i64 0))
    ret i32 0
}


declare dso_local i32 @printf(i8*, ...)


