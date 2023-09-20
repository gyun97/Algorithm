import sys

N = (sys.stdin.readline().strip())

nums = sorted(list(map(int, N)), reverse=True)
print(*nums, sep='')