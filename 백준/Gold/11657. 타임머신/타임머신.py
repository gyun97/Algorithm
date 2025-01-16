import sys
input = sys.stdin.readline

N, M = map(int, input().split())  # N : 도시의 개수 , M : 버스 노선의 개수
inf = float('inf')
graph = [[] for _ in range(N + 1)]
dist = [inf] * (N + 1)

for _ in range(M):
    start, end, weight = map(int, input().split())
    graph[start].append([end, weight])

# print(graph)


def bellman_ford(start):
    dist[start] = 0
    for _ in range(N - 1):
        update = False
        for i in range(1, N + 1):
            for end, weight in graph[i]:
                if dist[i] == inf:
                    break
                if dist[end] > dist[i] + weight:
                    dist[end] = dist[i] + weight
                    update = True

        if not update:
            break

    if update:
        for i in range(N):
            for end, weight in graph[i]:
                if dist[i] == inf:
                    break
                if dist[end] > dist[i] + weight:
                    return True

    return False


if bellman_ford(1):
    print(-1)
else:
    for i in range(2, N + 1):
        if dist[i] == inf:
            print(-1)
        else:
            print(dist[i])
