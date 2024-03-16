from collections import deque
import sys

N, M = map(int, sys.stdin.readline().split())

maze = []
maze.extend([list(map(int, sys.stdin.readline().strip())) for _ in range(N)])  # 2차원 배열 입력받기


def bfs_maze(x, y):  # (x, y) = 시작 좌표 (0, 0) / 실제로는 (1, 1)이지만 0부터 시작하는 인덱스의 특성
    """bfs로 미로의 (0, 0)에서 시작하여 (N-1, M-1)까지의 최단거리를 구하는 함수"""

    # 상하좌우
    dx = [1, -1, 0, 0]  # 행 이동
    dy = [0, 0, 1, -1]  # 열 이동

    queue = deque([(x, y)])     
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]  # next_x       
            ny = y + dy[i]  # next_y

            if (0 <= nx < N and 0 <= ny < M) and maze[nx][ny] == 1:  # 미로의 범위를 벗어나지 않고, 아직 방문하지 않은 연결된 칸이라면
                queue.append((nx, ny))
                maze[nx][ny] = maze[x][y] + 1  # 이전 칸의 값에 1을 더해줌으로써 현재 칸의 최단거리를 구함 

    return maze[N-1][M-1]   # (N-1, M-1)까지의 최단거리 반환

print(bfs_maze(0, 0)) 












