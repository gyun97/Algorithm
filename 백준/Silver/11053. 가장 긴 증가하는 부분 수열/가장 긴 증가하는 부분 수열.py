import sys
input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
dp = [1] * N


def LIS():
    for i in range(N - 1):
        for j in range(i + 1, N):
            if A[i] < A[j]:
                dp[j] = max(dp[j], dp[i] + 1)


LIS()
# print(dp)
print(max(dp))



