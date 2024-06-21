import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

N = int(input())

grid = [input().strip() for _ in range(N)]

# print(grid)

visited = [[False] * N for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

normal_count = 0


def dfs(x, y):
    a = grid[x][y]
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 > nx or nx >= N or 0 > ny or ny >= N or visited[nx][ny]:
            continue
        if a == grid[nx][ny]:
            visited[nx][ny] = True
            dfs(nx, ny)


for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            normal_count += 1
            dfs(i, j)


color_weakness_count = 0
visited = [[False] * N for _ in range(N)]

for i in range(N):
    grid[i] = grid[i].replace('G', 'R')

# print(grid)


for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            color_weakness_count += 1
            dfs(i, j)


print(normal_count, color_weakness_count)