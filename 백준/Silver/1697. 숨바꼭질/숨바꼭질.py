import sys

from collections import deque

N, K = map(int, input().split())

MAX = 10 ** 5

visited = [0] * (MAX + 1)

def bfs(x):
    queue = deque([x])
    while queue:
        x = queue.popleft()
        if x == K:
            return visited[x]
        dx = [x - 1, x + 1, 2 * x]
        for nx in dx:
            if 0 <= nx <= MAX and not visited[nx]:
                visited[nx] = visited[x] + 1
                queue.append(nx)

print(bfs(N))
