from collections import deque
import sys

N, M, V = map(int, sys.stdin.readline().split()) # N: 정점, M: 간선, V: 시작 노드


graph = [[0 for i in range(N+1)] for i in range(N+1)]

for _ in range(M):
    x, y = map(int, sys.stdin.readline().split())
    graph[x][y] = 1
    graph[y][x] = 1

visited_dfs = [0] * (N + 1)
visited_bfs = [0] * (N + 1)


def bfs(V):
    queue = deque([V])
    visited_bfs[V] = 1
    while queue:
        V = queue.popleft()
        print(V, end=" ")
        for i in range(1, N+1):
            if graph[V][i] == 1 and visited_bfs[i] == 0:
                queue.append(i)
                visited_bfs[i] = 1


def dfs(V):
    visited_dfs[V] = 1
    print(V, end=" ")
    for i in range(1, N+1):
        if graph[V][i] == 1 and visited_dfs[i] == 0:
            dfs(i)


dfs(V)
print()
bfs(V)












