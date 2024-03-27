import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

results = []


def bfs(x):
    queue = deque([x])
    visited[x] = True
    while queue:
        x = queue.popleft()
        for nx in graph[x]:
            if not visited[nx]:
                visited[nx] = True
                count[nx] = count[x] + 1
                queue.append(nx)
    return sum(count)


for i in range(1, N + 1):
    count = [0 for _ in range(N + 1)]
    visited = [False] * (N + 1)
    results.append(bfs(i))


answer = min(results)
print(results.index(answer) + 1)
