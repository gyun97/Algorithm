import sys

N, K = map(int, sys.stdin.readline().split())
n = 1
m = 1

for i in range(N, N-K, -1):
    n *= i


for j in range(1, K+1):
    m *= j

print(n//m)
