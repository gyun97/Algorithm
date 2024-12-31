import sys, heapq

input = sys.stdin.readline

N = int(input())

abs_heap = []

for _ in range(N):
    num = int(input())
    if num:
        heapq.heappush(abs_heap, (abs(num), num))
    else:
        if abs_heap:
            print(heapq.heappop(abs_heap)[1])
        else:
            print(0)





