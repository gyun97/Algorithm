import sys
import heapq
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

V, E = map(int, input().split())
parent = [x for x in range(V + 1)]
pq = []

for _ in range(E):
    start, end, weight = map(int, input().split())
    heapq.heappush(pq, (weight, start, end))

# print(pq)


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def check_same(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        return False
    return True


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


while edge_use < V - 1:
    weight, start, end = heapq.heappop(pq)
    if not check_same(start, end):
        total_sum += weight
        union(start, end)
        edge_use += 1

print(total_sum)


