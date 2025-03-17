import sys

input = sys.stdin.readline
inf = float('inf')

T = int(input())

for _ in range(T):
    K = int(input())
    files = list(map(int, input().split()))
    sums = [0] * (K + 1)
    for i in range(K):
        sums[i + 1] = files[i] + sums[i]
    dp = [[0] * (K + 1) for _ in range(K + 1)]

    for gap in range(1, K):
        for start in range(1, K - gap + 1):
            end = start + gap
            dp[start][end] = inf
            for mid in range(start, end):
                dp[start][end] = min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + (sums[end] - sums[start - 1]))

    # print(dp)
    print(dp[1][K])
















