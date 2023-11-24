from sys import stdin
from collections import deque

queue = deque()

N = int(stdin.readline().strip())

for _ in range(N):
    order = list(map(str, stdin.readline().split()))
    if order[0] == "push":
        queue.append(order[1])
    elif order[0] == "pop":
        if len(queue) != 0:
            print(queue.popleft())
        else:
            print(-1)
    elif order[0] == "size":
        print(len(queue))
    elif order[0] == "empty":
        if len(queue) != 0:
            print(0)
        else:
            print(1)
    elif order[0] == "front":
        if len(queue) != 0:
            print(queue[0])
        else:
            print(-1)
    elif order[0] == "back":
        if len(queue) != 0:
            print(queue[-1])
        else:
            print(-1)