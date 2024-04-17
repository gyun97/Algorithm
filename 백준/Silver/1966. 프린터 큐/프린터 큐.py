from collections import deque

T = int(input())

for _ in range(T):
    num, idx = map(int, input().split())
    docs = list((map(int, input().split())))
    queue = deque(enumerate(docs))
    count = 0
    while queue:
        i, j = queue.popleft()  # i = index, j = 중요도(문서)
        if j == max(docs):
            if i == idx:
                count += 1
                break
            else:
                count += 1
                docs.remove(j)
        else:
            queue.append((i, j))
    print(count)


