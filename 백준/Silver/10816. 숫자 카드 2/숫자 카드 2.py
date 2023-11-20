from sys import stdin
from collections import Counter

N = int(stdin.readline().strip())
cards = list(map(int, stdin.readline().split()))

M = int(stdin.readline().strip())
num = list(map(int, stdin.readline().split()))

answer = []

cards_count = Counter(cards)

for i in num:
    if i in cards_count.keys():
        answer.append(cards_count[i])
    else:
        answer.append(0)

print(*answer)
