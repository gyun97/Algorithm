from collections import deque
import sys

N = int(sys.stdin.readline())

queue = deque()

for i in range(1, N+1):
    queue.append(i)

while True:
    if len(queue) == 1:
        break
    queue.popleft()
    last = queue[0]
    queue.popleft()
    queue.append(last)

print(*queue)