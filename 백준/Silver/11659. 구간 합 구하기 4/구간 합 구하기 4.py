import sys
input = sys.stdin.readline

N, M = map(int, input().split())

nums = list(map(int, input().split()))

temp = 0
prefix_sum = [0]  # 인덱스 1부터 시작하게 0

for i in nums:
    temp += i
    prefix_sum.append(temp)

# print(nums)
# print(prefix_sum)

for _ in range(M):
    i, j = map(int, input().split())
    print(prefix_sum[j] - prefix_sum[i - 1])




