import sys
from collections import deque
sys.setrecursionlimit(10**6) # 백준에서는 재귀 제한을 늘려줘야 런타임 에러가 발생하지 않는다.


N, M = map(int, sys.stdin.readline().split())

graph = [[] for _ in range(N+1)]  # 0번 인덱스는 사용하지 않기 위해  N + 1.


for i in range(M):  # 양방향 그래프이므로 두번 연결해준다.
    u, v = map(int, sys.stdin.readline().split())  # u -> v , v -> u
    graph[u].append(v)  # u와 v를 연결
    graph[v].append(u)  # v와 u를 연결


visited = [False] * (N + 1)     # 방문한 노드를 체크하기 위한 리스트(역시 0번 인덱스는 사용하지 않기 위해 N + 1)


def dfs(start):
    visited[start] = True   # 방문한 노드를 체크
    for i in graph[start]:  # 현재 노드와 연결된 노드를 탐색
        if not visited[i]:  # 방문하지 않은 노드라면
            visited[i] = True  # 방문한 노드로 체크
            dfs(i)  # 재귀적으로 탐색


count = 0  # 연결 요소의 개수를 세기 위한 변수

for i in range(1, N + 1):  # 모든 노드를 탐색
    if not visited[i]:  # 방문하지 않은 노드라면
        dfs(i)  # dfs 탐색
        count += 1  # dfs 한 번 끝날 때마다 연결 요소의 개수를 1 증가


print(count)


