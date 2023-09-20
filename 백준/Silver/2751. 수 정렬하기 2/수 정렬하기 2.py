import sys

N = int(sys.stdin.readline().strip())

nums = [int(sys.stdin.readline().strip()) for _ in range(N)]

nums = sorted(nums)
# print(nums)

for num in nums:
    print(num)