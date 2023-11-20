from sys import stdin
from collections import deque

N = int(stdin.readline().strip())
deque = deque()

for _ in range(N):
    order = list(map(str, stdin.readline().split()))
    if order[0] == "push_front":
        deque.insert(0, order[1])
    elif order[0] == "push_back":
        deque.append(int(order[1]))
    elif order[0] == "pop_front":
        if len(deque) != 0:
            print(deque.popleft())
        else:
            print(-1)
    elif order[0] == "pop_back":
        if len(deque) != 0:
            print(deque.pop())
        else:
            print(-1)
    elif order[0] == "size":
        print(len(deque))
    elif order[0] == "empty":
        if len(deque) != 0:
            print(0)
        else:
            print(1)
    elif order[0] == "front":
        if len(deque) != 0:
            print(deque[0])
        else:
            print(-1)
    elif order[0] == "back":
        if len(deque) != 0:
            print(deque[-1])
        else:
            print(-1)


