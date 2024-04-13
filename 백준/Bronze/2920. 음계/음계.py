nums = [i for i in range(1, 9)]

num_input = list(map(int, input().split()))

if nums == num_input:
    print("ascending")
elif sorted(nums, reverse=True) == num_input:
    print("descending")
else:
    print("mixed")

