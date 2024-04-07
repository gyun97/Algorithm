import sys

N = int(sys.stdin.readline().strip())

price = [int(sys.stdin.readline().strip()) for _ in range(N)]

price.sort(reverse=True)

# 2, 5, 8, 11, 14...

discount = 0

for i in range(2, N, 3):
    discount += price[i]

price_sum = sum(price)

answer = price_sum - discount

print(answer)
