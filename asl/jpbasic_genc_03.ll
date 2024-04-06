
@.str.i = constant [3 x i8] c"%d\00"
@.str.s.1 = constant [3 x i8] c".\0A\00"




define dso_local void @f() {
  .entry:
    %a.addr = alloca i32
    %b.addr = alloca i32
    call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32* %a.addr)
    %.temp.1 = trunc i64 10 to i32
    %a.1 = load i32, i32* %a.addr
    %.temp.2 = icmp eq i32 %a.1, %.temp.1
    br i1 %.temp.2, label %.br.cont.1, label %endif1
  .br.cont.1:
    %.temp.3 = trunc i64 3 to i32
    store i32 %.temp.3, i32* %a.addr
    br label %endif1
  endif1:
    %.temp.4 = trunc i64 67 to i32
    %a.2 = load i32, i32* %a.addr
    %.temp.5 = add i32 %a.2, %.temp.4
    store i32 %.temp.5, i32* %b.addr
    %b.1 = load i32, i32* %b.addr
    %a.3 = load i32, i32* %a.addr
    %.temp.6 = add i32 %b.1, %a.3
    %.temp.7 = trunc i64 1 to i32
    %.temp.8 = add i32 %.temp.6, %.temp.7
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %.temp.8)
    ret void
}

define dso_local i32 @main() {
  .entry:
    %a.addr = alloca i32
    call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32* %a.addr)
    %.temp.1 = trunc i64 3 to i32
    %a.1 = load i32, i32* %a.addr
    %.temp.2 = icmp eq i32 %a.1, %.temp.1
    br i1 %.temp.2, label %.br.cont.1, label %endif1
  .br.cont.1:
    call void @f()
    br label %endif1
  endif1:
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.s.1, i64 0, i64 0))
    ret i32 0
}


declare dso_local i32 @printf(i8*, ...)
declare dso_local i32 @__isoc99_scanf(i8*, ...)


