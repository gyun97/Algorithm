import sys
input = sys.stdin.readline
# sys.setrecursionlimit(10**6)

R, C = map(int, input().split())

board = [list(sys.stdin.readline().strip()) for _ in range(R)]
visited = [False] * 26
max_depth = 0
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(x, y, depth):
    global max_depth
    max_depth = max(max_depth, depth)
    visited[ord(board[x][y]) - ord('A')] = True

    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < R and 0 <= ny < C:
            if not visited[ord(board[nx][ny]) - ord('A')]:
                dfs(nx, ny, depth + 1)

    visited[ord(board[x][y]) - ord('A')] = False


dfs(0, 0, 1)
print(max_depth)



