import sys
input = sys.stdin.readline
inf = float('inf')

N = int(input())

matrix = [[0, 0] for _ in range(N + 1)]
dp = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    a, b = map(int, input().split())
    matrix[i][0] = a
    matrix[i][1] = b


for len in range(2, N + 1):
    for i in range(1, N - len + 2):
        j = i + len - 1
        dp[i][j] = inf
        for k in range(i, j):
            cost = dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1])
            dp[i][j] = min(dp[i][j], cost)

print(dp[1][N])