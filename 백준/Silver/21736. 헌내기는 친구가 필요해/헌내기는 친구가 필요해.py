import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

map = [[] for _ in range(N)]
visited = [[False] * M for _ in range(N)]


for i in range(N):
    campus = input()
    for j in range(M):
        map[i].append(campus[j])
        if campus[j] == "I":
            x, y = i, j
        elif campus[j] == "X":
            visited[i][j] = True

count = 0

def bfs(x, y):
    global count
    queue = deque([(x, y)])
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and not visited[nx][ny]:

                queue.append((nx, ny))
                visited[nx][ny] = True
                if map[nx][ny] == "P":
                    count += 1


bfs(x, y)
print(count) if count > 0 else print("TT")