import sys
from collections import deque


N = int(sys.stdin.readline().strip())

M = int(sys.stdin.readline().strip())

graph = [[] for _ in range(N + 1)]

visited = [False] * (N + 1)

count = 0

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(x):
    global count
    queue = deque([x])
    visited[x] = True
    while queue:
        x = queue.popleft()
        for nx in graph[x]:
            if not visited[nx]:
                visited[nx] = True
                queue.append(nx)
                count += 1

bfs(1)
print(count)
