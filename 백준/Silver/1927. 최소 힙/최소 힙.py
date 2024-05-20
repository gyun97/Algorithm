import sys
import heapq

input = sys.stdin.readline

N = int(input())

heap = []
heapq.heapify(heap)

for _ in range(N):
    order = int(input())
    if order == 0:
        print(heapq.heappop(heap)) if len(heap) > 0 else print(0)
    else:
        heapq.heappush(heap, order)



