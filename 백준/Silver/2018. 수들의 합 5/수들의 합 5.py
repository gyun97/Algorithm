import sys
input = sys.stdin.readline

N = int(input().strip())

left = right = num_sum = answer_count = 1

while N != right:
    if num_sum < N:
        right += 1
        num_sum += right
    elif num_sum > N:
        num_sum -= left
        left += 1
    elif num_sum == N:
        answer_count += 1
        right += 1
        num_sum += right

print(answer_count)