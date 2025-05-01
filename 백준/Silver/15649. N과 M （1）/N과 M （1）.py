import sys
sys.setrecursionlimit(10**6)

input = sys.stdin.readline

N, M = map(int, input().split())

visited = [False] * (N + 1)
arr = [0] * M


def backtrace(depth):
    if depth == M:
        print(*arr)
        return

    for i in range(1, N + 1):
        if not visited[i]:
            visited[i] = True
            arr[depth] = i
            backtrace(depth + 1)
            visited[i] = False


backtrace(0)