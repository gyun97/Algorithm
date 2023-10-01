import sys

T=int(input())

for i in range(T):
    A,B=map(int,sys.stdin.readline().split())
    AA,BB=A,B

    while BB!=0:
        AA=AA%BB
        AA,BB=BB,AA

    print(A*B//AA)