import sys
sys.setrecursionlimit(10**6)
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

visited = [False] * (N + 1)

count = 0


def bfs(start):
    queue = deque([start])
    visited[start] = True
    while queue:
        node = queue.popleft()
        for i in graph[node]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)


for i in range(1, N + 1):
    if not visited[i]:
        count += 1
        bfs(i)


print(count)