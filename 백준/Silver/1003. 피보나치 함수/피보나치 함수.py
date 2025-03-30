import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

T = int(input())

dp = [[None, None] for _ in range(41)]

dp[0][0] = 1
dp[0][1] = 0
dp[1][0] = 0
dp[1][1] = 1


def fibonacci(N):
    if dp[N][0] is None or dp[N][1] is None:
        dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0]
        dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1]

    return dp[N]


for _ in range(T):
    N = int(input())
    print(fibonacci(N)[0], fibonacci(N)[1])



