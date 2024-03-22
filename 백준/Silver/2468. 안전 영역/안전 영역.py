# [bfs]

import sys
from collections import deque

N = int(sys.stdin.readline().strip())

area = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]  # 지역 정보

highest = max([max(row)for row in area])  # 지역에서의 최대 높이

dx = [1, -1, 0, 0]  # 상하
dy = [0, 0, 1, -1]  # 좌우

max_count = 0  # 안전 영역의 최대 개수


def bfs(x, y, highest):
    """bfs로 안전 영역의 개수를 구하는 함수"""
    queue = deque([(x, y)])
    visited[x][y] = True
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N:  # 지도를 벗어나지 않는 범위 내에서
                if not visited[nx][ny] and area[nx][ny] > highest:  # 방문하지 않았고, 물에 잠기지 않은 지역이라면
                    visited[nx][ny] = True
                    queue.append((nx, ny))


for i in range(highest):  # 높이를 0부터 최대 높이까지 순회하며(아무 지역도 물에 잠기지 않을 숟 있으므로 0부터 시작해도 무방하고 최대 높이면 어차피 모든 지역이 물에 잠겨서 무의미)
    count = 0  # count = 현재 높이에서의 안전 영역의 개수
    visited = [[False] * N for _ in range(N)]  # 방문 여부를 체크하는 리스트. 매 높이마다 초기화

    for j in range(N):      # 지역을 순회하며
        for k in range(N):  # 물에 잠기지 않은 지역을 찾아 bfs를 실행
            if not visited[j][k] and area[j][k] > i:  # 방문하지 않았고, 물에 잠기지 않은 지역이라면
                bfs(j, k, i)  # bfs 실행
                count += 1  # 해당 높이에서의 안전 영역의 개수 +1

    max_count = max(max_count, count)  # 안전 영역의 최대 개수 갱신


print(max_count)



# [dfs]

# import sys
# from collections import deque
# 
# N = int(sys.stdin.readline().strip())
# 
# graph = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
# 
# highest = max(max(row) for row in graph)
# 
# max_count = 0
# 
# dx = [1, -1, 0, 0]
# dy = [0, 0, 1, -1]
# 
# 
# def dfs(x, y, highest):
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if 0 <= nx < N and 0 <= ny < N:
#             if not visited[nx][ny] and graph[nx][ny] > highest:
#                 visited[nx][ny] = True
#                 dfs(nx, ny, highest)
# 
# 
# for i in range(highest):
#     visited = [[False] * N for _ in range(N)]
#     count = 0
#     for j in range(N):
#         for k in range(N):
#             if not visited[j][k] and graph[j][k] > i:
#                 dfs(j, k, i)
#                 count += 1
# 
#     max_count = max(max_count, count)
# 
# 
# print(max_count)





