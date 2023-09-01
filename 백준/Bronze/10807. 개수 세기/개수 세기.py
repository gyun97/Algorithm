import sys

N = int(sys.stdin.readline().strip())

elements = list(map(int, sys.stdin.readline().split()))

v = int(sys.stdin.readline().strip())

print(elements.count(v))