import sys

N = int(sys.stdin.readline().strip())

array = list(map(int, sys.stdin.readline().split()))

print(min(array), max(array))
