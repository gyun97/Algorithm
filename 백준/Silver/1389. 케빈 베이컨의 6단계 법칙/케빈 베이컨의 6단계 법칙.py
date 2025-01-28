import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())  # N: 유저(노드)의 수, M : 인맥(엣지)의 수

graph = [[] for _ in range(N + 1)]  # 노드간의 관계를 나타내는 인접 리스트
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)


def bfs(x):
    dist = [-1] * (N + 1)  # 현재 노드 x와 다른 노드들간의 거리를 나타내는 리스트(-1은 거리 미갱신, 0은 자기 자신)
    count = 0 # 현재 노드 x의 케빈 베이컨의 수
    queue = deque([x])
    dist[x] = 0  # 시작 노드 x의 거리 0으로 갱신
    while queue:
        cur = queue.popleft()  # x와의 거리를 구할 현재 노드
        for next in graph[cur]:  # cur 노드와의 인접 노드들
            if dist[next] == -1:  # 아직 해당 인접 노드와 거리 갱신이 되지 않았다면
                dist[next] = dist[cur] + 1  # 인접 노드는 cur 노드보다 시작 노드와 +1 더 멀다
                count += dist[cur]  # 케빈 베이컨 수를 구하기 위해 시작 노드와 cur 노드와의 거리 누적합
                queue.append(next)

    return count


min_count = sys.maxsize  # 현재의 최소 케빈 베이컨 수
min_idx = 0  # 현재의 최소 케빈 베이컨 수를 가진 유저

for i in range(1, N + 1):
    count = bfs(i)  # i 노드의 케빈 베이컨 수(다른 노드들과의 거리의 총합)을 구하기 위해 bfs 수행
    if min_count > count:  # 만약 최소 케빈 베이컨 수가 나온다면 최소 케빈 베이컨 수, 최소 유저 갱신
        min_count = count  
        min_idx = i

print(min_idx)




