import sys
input = sys.stdin.readline

n = int(input())

dp = [0] * (1000 + 1)

# 1과 2의 합을 이용해서 n 만들기

dp[1] = 1
dp[2] = 2

for i in range(3, n + 1):
    dp[i] = (dp[i - 1] + dp[i - 2]) % 10007


print(dp[n])


