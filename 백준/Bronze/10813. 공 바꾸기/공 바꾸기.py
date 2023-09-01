import sys

N, M = map(int, sys.stdin.readline().split())

arr = [x for x in range(1, N+1)]  # [1,2,3,4,5]

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    arr[i-1], arr[j-1] = arr[j-1], arr[i-1]

for k in range(N):
    print(arr[k], end=" ")