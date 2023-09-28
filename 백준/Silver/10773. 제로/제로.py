from collections import deque
import sys

stack = deque()

K = int(sys.stdin.readline().strip())

for _ in range(K):
    x = int(input())
    if x == 0:
        stack.pop()
    else:
        stack.append(x)

print(sum(stack))