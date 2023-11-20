import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())

queue = deque()
answers = "<"
count = 0

for i in range(1, N+1):
    queue.append(i)


while len(queue) != 0:
    count += 1
    first = queue.popleft()
    if count % K == 0:
        answers += str(first)
        if len(queue) != 0:
            answers += ", "
    else:
        queue.append(first)
    

print(answers + ">")