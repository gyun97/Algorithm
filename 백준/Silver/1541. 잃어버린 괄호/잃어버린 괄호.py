import sys

exp = sys.stdin.readline().strip().split("-")

nums = []

for i in exp:
    elements = list(map(int, i.split("+")))
    temp = sum(elements)
    nums.append(temp)

result = nums[0]

for j in range(1, len(nums)):
    result -= nums[j]

print(result)

