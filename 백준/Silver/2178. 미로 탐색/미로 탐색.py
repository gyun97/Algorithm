import sys
from collections import deque

input =sys.stdin.readline

N, M = map(int, input().split())

graph = []
visited = [[False] * M for _ in range(N)]

for i in range(N):
    graph.append(list(map(int, input().strip())))


def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = True
    queue.append((x, y))
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if (0 <= nx < N and 0 <= ny < M) and (not visited[nx][ny] and graph[nx][ny] == 1):
                visited[nx][ny] = True
                queue.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1


bfs(0, 0)
print(graph[N - 1][M - 1])
