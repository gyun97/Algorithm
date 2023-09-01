import sys

N, M = map(int, sys.stdin.readline().split())

arr = [0] * N

for _ in range(M):
    i, j, k = map(int, sys.stdin.readline().split())
    for x in range(i, j+1):
        arr[x-1] = k

for y in range(N):
    print(arr[y], end=' ')