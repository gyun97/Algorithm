import sys
from collections import deque

N, M, V = map(int, sys.stdin.readline().split())  # N: 정점 수, M: 간선 수, V: 시작 정점 번호

graph = [[False] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph[x][y] = graph[y][x] = True


visited_bfs = [False] * (N + 1)
visited_dfs = [False] * (N + 1)


def dfs(V):
    visited_dfs[V] = True
    print(V, end=" ")
    for i in range(1, N+1):
        if graph[V][i] and not visited_dfs[i]:
            dfs(i)

def bfs(V):
    queue = deque([V])
    visited_bfs[V] = True
    while queue:
        V = queue.popleft()
        print(V, end=" ")
        for i in range(1, N+1):
            if graph[V][i] and not visited_bfs[i]:
                queue.append(i)
                visited_bfs[i] = True

dfs(V)
print()
bfs(V)