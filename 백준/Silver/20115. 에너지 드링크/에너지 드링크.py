import sys

N = int(sys.stdin.readline().strip())

drinks = list(map(int, sys.stdin.readline().split()))

drinks.sort(reverse=True)

sum = 0

for i in range(1, N):
    sum += drinks[i] / 2

answer = (drinks[0] + sum)
print(answer)
