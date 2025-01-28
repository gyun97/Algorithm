import sys
from collections import deque
input = sys.stdin.readline


N = int(input())  # 노드 수
M = int(input())  # 간선 수

# 노드 연결 정보 담은 그래프 초기화
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [False] * (N + 1)  # 노드 방문 여부 확인 리스트
count = 0  # 1번 컴퓨터가 감염시키는 연결된 컴퓨터의 수


def bfs(x):
    """bfs로 그래프 탐색해서 1번 노드와 몇 개의 노드가 연결되어 있는지 확인"""
    global count
    queue = deque([x])
    visited[x] = True
    while queue:
        cur = queue.popleft()
        for next in graph[cur]:
            if not visited[next]:
                count += 1
                visited[next] = True
                queue.append(next)

    return count


print(bfs(1))

