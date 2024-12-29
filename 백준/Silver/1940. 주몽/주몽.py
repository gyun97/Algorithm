import sys
input = sys.stdin.readline

N = int(input().strip())
M = int(input().strip())
num_list = list(map(int, input().split()))

# print(num_list)

num_list.sort()

left = 0
right = N - 1
answer_count = 0

while left < right:
    num_sum = num_list[left] + num_list[right]
    a = num_list[left]
    b = num_list[right]

    if num_sum < M:
        left += 1
    elif num_sum > M:
        right -= 1
    elif num_sum == M:
        answer_count += 1
        right -= 1
        left += 1

print(answer_count)






