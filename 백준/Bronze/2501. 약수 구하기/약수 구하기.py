import sys

N, K = list(map(int, sys.stdin.readline().split()))
big = (max(N, K))
small = (min(N, K))
count = 0

for i in range(1, big+1):
    if big % i == 0:
        count += 1
        if count == small:
            print(i)
            break

if small > count:
    print(0)