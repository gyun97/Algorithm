import sys
from collections import deque
input = sys.stdin.readline

M, N = map(int, input().split())  # M: 가로, N: 세로

tomatoes = [list(map(int, input().split())) for _ in range(N)]


queue = deque()

for i in range(N):
    for j in range(M):
        if tomatoes[i][j] == 1:
            queue.append([i, j])


def bfs():
    while queue:
        x, y = queue.popleft()
        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and tomatoes[nx][ny] == 0:
                    queue.append((nx, ny))
                    tomatoes[nx][ny] = tomatoes[x][y] + 1

bfs()


day = 0

for row in tomatoes:
    for i in row:
        if i == 0:
            print(-1)
            exit()
        else:
            day = max(day, max(row))


print(day - 1)




