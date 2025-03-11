import sys
import heapq
input = sys.stdin.readline

M, N = map(int, input().split())

graph = []
for _ in range(M):
    graph.append(list((map(int, input().split()))))
# print(graph)

visited = [[0] * N for _ in range(M)]


def bfs(x, y):
    pq = []
    heapq.heappush(pq, (-graph[x][y], x, y))
    visited[x][y] = 1
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while pq:
        cur = heapq.heappop(pq)
        cur_val = cur[0]
        cur_x = cur[1]
        cur_y = cur[2]
        for i in range(4):
            nx = cur_x + dx[i]
            ny = cur_y + dy[i]
            if 0 <= nx < M and 0 <= ny < N and cur_val < -graph[nx][ny]:
                if visited[nx][ny] == 0:
                    heapq.heappush(pq, (-graph[nx][ny], nx, ny))
                visited[nx][ny] += visited[cur_x][cur_y]


bfs(0, 0)
# print(visited)
print(visited[M - 1][N - 1])