import sys
import math
input = sys.stdin.readline

M, N = map(int, input().split())

arr = [x for x in range(0, N + 1)]
arr[1] = 0

for i in range(2, int(math.sqrt(N) + 1)):
    if arr[i] == 0:
        continue
    for j in range(i + i, N + 1, i):
        arr[j] = 0

for i in arr:
    if i >= M and arr[i] != 0:
        print(arr[i])