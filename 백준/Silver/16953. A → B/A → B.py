from collections import deque

A, B = map(int, input().split())

queue = deque([(A, 1)])

while queue:
    current, count = queue.popleft()
    if current == B:
        print(count)
        break
    elif current > B:
        continue
    else:
        queue.append((current * 2, count + 1))
        queue.append((current * 10 + 1, count + 1))
else:
    print(-1)


