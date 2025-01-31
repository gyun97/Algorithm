import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


d = [(-1, -1), (-1, 0), (-1, 1),  # 북서, 북, 북동 
     (0, -1), (0, 1),  # 서, 동
     (1, -1), (1, 0), (1, 1)]  # 남서, 남, 남동


def dfs(x, y):
    for i in range(8):
        nx = x + d[i][0]
        ny = y + d[i][1]
        if 0 <= nx < h and 0 <= ny < w:
            if not visited[nx][ny] and graph[nx][ny] == 1:
                visited[nx][ny] = True
                dfs(nx, ny)


while True:
    w, h = map(int, input().split())  # w : 너비, h : 높이
    if w == h == 0:
        break

    graph = [[] for _ in range(h)]
    for i in range(h):
        graph[i] = list(map(int, input().split()))
    # print(graph)

    visited = [[False] * w for _ in range(h)]
    # print(visited)

    count = 0

    for i in range(h):
        for j in range(w):
            if not visited[i][j] and graph[i][j] == 1:
                count += 1
                dfs(i, j)
    print(count)