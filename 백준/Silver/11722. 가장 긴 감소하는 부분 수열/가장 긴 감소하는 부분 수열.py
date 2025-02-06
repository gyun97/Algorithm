import sys

input = sys.stdin.readline

N = int(input())
dp = [0] * N
order = list(map(int, input().split()))

max_len = 0


def find_lds(idx):
    if dp[idx] != 0:
        return dp[idx]

    dp[idx] = 1
    for prev in range(idx):
        if order[prev] > order[idx]:
            dp[idx] = max(dp[idx], find_lds(prev) + 1)
    return dp[idx]


for i in range(N):
    max_len = max(max_len, find_lds(i))

print(max_len)