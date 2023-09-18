import sys

A, B = map(str, sys.stdin.readline().split())

A = A[::-1]
B = B[::-1]

print(max(int(A), int(B)))