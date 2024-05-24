import sys

input = sys.stdin.readline

N = int(input())

nums = list(map(int, input().split()))

set_nums = sorted(set(nums))

# print(set_nums)

dict_nums = {}

# [시간 초과로 틀린 풀이]
# for num in nums:
#     dict_nums[num] = set_nums.index(num)  # index()는 시간 복잡도 O(N)여서 매번 1000000번 연산해야 해서 결국 O(N^2)이 되어서 시간 초과
#     print(dict_nums[num], end = " ")


# [풀이 1]
# for i in range(len(set_nums)):
#     dict_nums[set_nums[i]] = i


# [풀이 2]
for idx, num in enumerate(set_nums):
    dict_nums[num] = idx


for j in nums:
    print(dict_nums[j], end = " ")
