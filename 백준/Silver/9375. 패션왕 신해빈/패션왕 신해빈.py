from collections import Counter
import sys

input = sys.stdin.readline

t = int(input())

for _ in range(t):
    n = int(input())
    wears = []
    count = 1
    for _ in range(n):
        cloth, kind = input().split()
        wears.append(kind)
    wears_counter = Counter(wears)
    # print(wears_counter)
    for i in wears_counter.values():
        count *= (i + 1)
    print(count - 1)




