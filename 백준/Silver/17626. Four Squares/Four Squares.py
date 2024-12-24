import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (N + 1)


for i in range(1, N + 1):
    dp[i] = i
    j = 1
    while j ** 2 <= i:
        dp[i] = min(dp[i], dp[i - j ** 2] + 1)
        j += 1

print(dp[N])