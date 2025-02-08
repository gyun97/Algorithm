import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1] * M for _ in range(N)]

# print(arr)
# print(dp)


def dfs(x, y):
    if x == N - 1 and y == M - 1:  # 만약 목표 지점에 도달했다면
        return 1  # 목표 지점 직전의 칸의 경로의 개수는 1

    if dp[x][y] != -1:  # 이미 방문한 칸이어서 -1이 아니라면
        return dp[x][y]  # 해당 칸의 경로의 개수 바로 반환

    dp[x][y] = 0  # 처음 방문하는 칸 방문 표시

    dx = [-1, 1, 0, 0]  # 상,하 1칸씩 이동
    dy = [0, 0, -1, 1]  # 좌,우 1칸씩 이동
    for i in range(4):
        nx = x + dx[i]  
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if arr[x][y] > arr[nx][ny]:
                dp[x][y] += dfs(nx, ny)

    return dp[x][y]


print(dfs(0, 0))