import sys

input = sys.stdin.readline

N = int(input())

schedule = [[0, 0] for _ in range(N + 2)]
dp = [0] * (N + 2)

for i in range(1, N + 1):
    time, pay = map(int, input().split())
    schedule[i][0] = time
    schedule[i][1] = pay


max_pay = - 1
for i in range(1, N + 2):
    if max_pay < dp[i]:
        max_pay = dp[i]

    next = i + schedule[i][0]
    if next <= N + 1:
        dp[next] = max(dp[next], max_pay + schedule[i][1])


print(dp[N + 1])



