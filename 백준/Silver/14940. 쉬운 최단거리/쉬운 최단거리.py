# import sys
#
# input = sys.stdin.readline
#
# from collections import deque
#
# n, m = map(int, input().split())  # n:세로, m: 가로
#
# map = [list((map(int, input().split()))) for _ in range(n)]
# # print(map)
#
# dis = [([0] * m) for _ in range(n)]
# visited = [([0] * m) for _ in range(n)]
#
# # print(dis)
#
# def bfs(x, y):
#     queue = deque([(x, y)])
#     visited[x][y] = 1
#     while queue:
#         x, y = queue.popleft()
#         for i in range(4):
#             dx = [1, -1, 0, 0]
#             dy = [0, 0, 1, -1]
#             nx = x + dx[i]
#             ny = y + dy[i]
#             if 0 <= nx < n and 0 <= ny < m and map[nx][ny] == 1 and visited[nx][ny] == 0:
#                 dis[nx][ny] = dis[x][y] + 1
#                 visited[nx][ny] = 1
#                 queue.append((nx, ny))
#
# for i in range(n):
#     for j in range(m):
#         if map[i][j] == 2:
#             bfs(i, j)
#
# print(dis)
#
#
#
#
#
import sys

input = sys.stdin.readline

from collections import deque

n, m = map(int, input().split())  # n:세로, m: 가로

map = [list((map(int, input().split()))) for _ in range(n)]

dis = [([0] * m) for _ in range(n)]
visited = [([0] * m) for _ in range(n)]


def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = 1
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            dx = [1, -1, 0, 0]
            dy = [0, 0, 1, -1]
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and map[nx][ny] == 1 and visited[nx][ny] == 0:
                dis[nx][ny] = dis[x][y] + 1
                visited[nx][ny] = 1
                queue.append((nx, ny))

for i in range(n):
    for j in range(m):
        if map[i][j] == 2:
            bfs(i, j)

for i in range(n):
    for j in range(m):
        if map[i][j] == 1 and dis[i][j] == 0:
            dis[i][j] = -1


for i in dis:
    print(*i)

