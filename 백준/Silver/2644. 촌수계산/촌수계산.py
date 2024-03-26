import sys
from collections import deque

n = int(sys.stdin.readline().strip())

a, b = map(int, sys.stdin.readline().split())

m = int(sys.stdin.readline().strip())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y = map(int, sys.stdin.readline().split())
    graph[x].append(y)
    graph[y].append(x)

count = [0] * (n + 1)


def dfs(node):
    for next in graph[node]:
        if not count[next]:
            count[next] = count[node] + 1
            dfs(next)

dfs(a)
print(count[b]) if count[b] > 0 else print(-1)
