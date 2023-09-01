import sys

A, B = map(int, sys.stdin.readline().split())
C = int(sys.stdin.readline().strip())

if (B + C) >= 60:
    A = A+((B+C)//60)
    B = (B+C)%60
    if A >= 24:
        A = A - 24
    print(A, B)
else:
    print(A, B+C)