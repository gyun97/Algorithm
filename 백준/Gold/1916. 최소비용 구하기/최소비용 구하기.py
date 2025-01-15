import heapq
import sys
input = sys.stdin.readline

inf = float('inf')

N = int(input())
M = int(input())

graph = [[] for _ in range(N + 1)]  # 인접 노드들을 담을 인접 리스트
for _ in range(M):
    A, B, weight = map(int, input().split())
    graph[A].append([B, weight])

# print(graph)

dist = [inf] * (N + 1)  # 시작점에서 각 노드까지의 최단 거리

start, end = map(int, input().split())


def dijkstra(start, end):
    heap = []
    heapq.heappush(heap, [start, 0])
    dist[start] = 0
    while heap:
        cur_node, cur_weight = heapq.heappop(heap)
        if dist[cur_node] < cur_weight:
            continue
        for next_node, next_weight in graph[cur_node]:
            sum_dist = cur_weight + next_weight
            if sum_dist < dist[next_node]:
                dist[next_node] = sum_dist
                heapq.heappush(heap, [next_node, sum_dist])

    return dist[end]


print(dijkstra(start, end))








