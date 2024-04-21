import sys
from collections import deque

input = sys.stdin.readline

T = int(input())


def bfs(i, j):
    global count
    queue = deque([(i, j)])
    graph[i][j] = 0
    dx = [1, -1, 0, 0]  # 좌우
    dy = [0, 0, 1, -1]  # 상하
    while queue:
        y, x = queue.popleft()
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if (0 <= nx < M and 0 <= ny < N) and graph[ny][nx]:
                queue.append((ny, nx))
                graph[ny][nx] = 0
    count += 1


for _ in range(T):

    M, N, K = map(int, input().split())

    # print(M, N, K)

    graph = [[0] * M for _ in range(N)]

    count = 0


    for _ in range(K):
        x, y = map(int, input().split())  # x: 열, y: 행
        graph[y][x] = 1

    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                bfs(i, j)

    print(count)


    

