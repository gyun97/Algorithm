from collections import deque
import sys
input = sys.stdin.readline


N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
degree = [0] * (N + 1)

for _ in range(M):
    A, B = map(int, input().split())
    graph[A].append(B)
    degree[B] += 1

# print(graph)

queue = deque()

for i in range(1, N + 1):
    if degree[i] == 0:
        queue.append(i)

# print(queue)

while queue:
    now = queue.popleft()
    print(now, end=" ")
    for node in graph[now]:
        degree[node] -= 1
        if (degree[node] == 0):
            queue.append(node)






