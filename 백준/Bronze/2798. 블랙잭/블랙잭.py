import sys

N, M = map(int, sys.stdin.readline().split())

cards = list(map(int, sys.stdin.readline().split()))

sums = []

for i in range(N-2):
    for j in range(i+1, N-1):
        for k in range(j+1, N):
            sum_of_card = cards[i] + cards[j] + cards[k]
            if sum_of_card <= M:
                sums.append(sum_of_card)

print(max(sums))