
@.str.i = constant [3 x i8] c"%d\00"
@.str.f = constant [3 x i8] c"%g\00"
@.str.s.1 = constant [2 x i8] c"\0A\00"




define dso_local i32 @main() {
  .entry:
    %a.addr = alloca i32
    %b.addr = alloca i32
    %end.addr = alloca i1
    %pi.addr = alloca float
    %.temp.1 = trunc i64 12 to i32
    store i32 %.temp.1, i32* %a.addr
    %.temp.3 = trunc i64 5 to i32
    %a.1 = load i32, i32* %a.addr
    %.temp.2 = mul i32 %a.1, %.temp.3
    %.temp.7 = trunc i64 1 to i32
    %a.2 = load i32, i32* %a.addr
    %.temp.6 = add i32 %a.2, %.temp.7
    %a.3 = load i32, i32* %a.addr
    %.temp.5 = mul i32 %a.3, %.temp.6
    %.temp.4 = add i32 %.temp.2, %.temp.5
    store i32 %.temp.4, i32* %b.addr
    %a.4 = load i32, i32* %a.addr
    %b.1 = load i32, i32* %b.addr
    %.temp.8 = icmp sle i32 %a.4, %b.1
    %.temp.11 = trunc i64 0 to i32
    %a.5 = load i32, i32* %a.addr
    %.temp.12 = icmp eq i32 %a.5, %.temp.11
    %.temp.14 = xor i1 %.temp.12, 1
    %.temp.10 = and i1 %.temp.8, %.temp.14
    store i1 %.temp.10, i1* %end.addr
    %.temp.15 = fptrunc double 3.3 to float
    %.temp.17 = trunc i64 1 to i32
    %a.6 = load i32, i32* %a.addr
    %.temp.18 = sdiv i32 %.temp.17, %a.6
    %.temp.19 = sitofp i32 %.temp.18 to float
    %.temp.16 = fadd float %.temp.15, %.temp.19
    %.temp.21 = fptrunc double 2.0 to float
    %.temp.22 = fneg float %.temp.21
    %a.7 = load i32, i32* %a.addr
    %.temp.24 = sitofp i32 %a.7 to float
    %.temp.23 = fdiv float %.temp.22, %.temp.24
    %.temp.20 = fsub float %.temp.16, %.temp.23
    store float %.temp.20, float* %pi.addr
    %a.8 = load i32, i32* %a.addr
    %b.2 = load i32, i32* %b.addr
    %.temp.25 = icmp eq i32 %a.8, %b.2
    %end.1 = load i1, i1* %end.addr
    %.temp.27 = or i1 %.temp.25, %end.1
    %.wrti.i32.1 = zext i1 %.temp.27 to i32
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %.wrti.i32.1)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.s.1, i64 0, i64 0))
    %a.9 = load i32, i32* %a.addr
    %b.3 = load i32, i32* %b.addr
    %.temp.28 = mul i32 %a.9, %b.3
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.i, i64 0, i64 0), i32 %.temp.28)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.s.1, i64 0, i64 0))
    %.temp.29 = trunc i64 2 to i32
    %.temp.31 = sitofp i32 %.temp.29 to float
    %pi.1 = load float, float* %pi.addr
    %.temp.30 = fmul float %.temp.31, %pi.1
    %.wrtf.double.1 = fpext float %.temp.30 to double
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.f, i64 0, i64 0), double %.wrtf.double.1)
    call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([2 x i8], [2 x i8]* @.str.s.1, i64 0, i64 0))
    ret i32 0
}


declare dso_local i32 @printf(i8*, ...)


