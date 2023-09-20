import sys
# import statistics

nums = [int(sys.stdin.readline().strip()) for _ in range(5)]

# avg_nums = statistics.mean(nums)
avg_nums = sum(nums) / 5
print(int(avg_nums))
#
# avg_median = statistics.median(nums)
sorted_nums = sorted(nums)
avg_median = sorted_nums[2]
print(avg_median)