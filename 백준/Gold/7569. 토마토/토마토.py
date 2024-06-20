import sys
from collections import deque

input = sys.stdin.readline

M, N, H = map(int, input().split())

tomato = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]

# tomato = []
# for _ in range(H):
#     layer = []
#     for _ in range(N):
#         row = list(map(int, input().split()))
#         layer.append(row)
#     tomato.append(layer)

# print(tomato) => [[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]], [[0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]]

queue = deque()

for i in range(H):
    for j in range(N):
        for k in range(M):
            if tomato[i][j][k] == 1:
                queue.append((i, j, k))


def bfs():
    while queue:
        z, x, y = queue.popleft()
        dz = [1, -1, 0, 0, 0, 0]
        dx = [0, 0, 1, -1, 0, 0]
        dy = [0, 0, 0, 0, 1, -1]
        for i in range(6):
            nz = z + dz[i]
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 > nz or nz >= H or 0 > nx or nx >= N or 0 > ny or ny >= M:
                continue
            if tomato[nz][nx][ny] == 0:
                tomato[nz][nx][ny] = tomato[z][x][y] + 1
                queue.append((nz, nx, ny))


bfs()

day = 0


def check_result():
    global i, j, day
    for i in tomato:
        for j in i:
            if 0 in j:
                day = -1
                return
            else:
                day = max(day, max(j))


check_result()

print(day - 1) if day != -1 else print(-1)
