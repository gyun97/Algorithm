import sys
import heapq
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

V, E = map(int, input().split())
parent = [x for x in range(V + 1)]
pq = []

# 간선 데이터를 최소 힙에 삽입
for _ in range(E):
    start, end, weight = map(int, input().split())
    heapq.heappush(pq, (weight, start, end))  # 가중치 기준 정렬

# 부모 노드를 찾는 함수
def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])  # 경로 압축
    return parent[a]

# 같은 집합인지 확인하는 함수
def check_same(a, b):
    a = find(a)
    b = find(b)
    return a == b

# 두 집합을 합치는 함수
def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        if a < b:
            parent[b] = a
        else:
            parent[a] = b

total_sum = 0
edge_use = 0

# 크루스칼 알고리즘 실행
while edge_use < V - 1 and pq:
    weight, start, end = heapq.heappop(pq)  # 최소 가중치 간선 꺼내기
    if not check_same(start, end):  # 사이클이 생기지 않으면
        total_sum += weight
        union(start, end)
        edge_use += 1

print(total_sum)
