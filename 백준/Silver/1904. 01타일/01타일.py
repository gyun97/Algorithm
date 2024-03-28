import sys
input = sys.stdin.readline

N = int(input().strip())

"""
1은 한 자리여서 자릿수 N을 초과하지 않기 때문에 바로 직전 결과들에 붙일 수 있고,
00은 두 자리이기 때문에 바로 직전 결과들에 붙이면 자릿수를 초과하기 때문에 전전 결과들에 붙일 수 있다.
결과적으로 dp[N] = dp[N - 1] + dp[N - 2]이다.
"""


def dp(N):
    table = [None, 1, 2]
    for i in range(3, N + 1):
        table.append((table[i - 1] + table[i - 2]) % 15746)

    return table[N]

print(dp(N))




