import sys
import heapq
input = sys.stdin.readline

N = int(input())

lectures = sorted([list((map(int, input().split()))) for _ in range(N)], key=lambda x: (x[0], x[1]))
# print(lectures)

pq = []

for lecture in lectures:
    start_time = lecture[0]
    end_time = lecture[1]
    if pq and pq[0] <= start_time:
            heapq.heappop(pq)
    heapq.heappush(pq, end_time)

print(len(pq))


