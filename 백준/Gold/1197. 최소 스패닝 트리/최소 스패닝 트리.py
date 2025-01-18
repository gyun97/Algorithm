import sys
from queue import PriorityQueue
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

v, e = map(int, input().split())
parent = [x for x in range(v + 1)]
# print(parent)

pq = PriorityQueue()

for _ in range(e):
    start, end, weight = map(int, input().split())
    pq.put((weight, start, end))  # 가중치 기준이기 때문에 가중치를 가장 앞 순서 배치


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def check_same(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    return False


def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        if a < b:
            parent[b] = a
        else:
            parent[a] = b


use_edge = 0
total_sum = 0

while use_edge < v - 1:
    weight, start, end = pq.get()
    if not check_same(start, end):
        total_sum += weight
        use_edge += 1
        union(start, end)


print(total_sum)
