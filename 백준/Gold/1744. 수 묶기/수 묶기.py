import sys
import heapq
input = sys.stdin.readline

N = int(input())
over = []
under = []

answer = 0

for _ in range(N):
    num = int(input())
    if num == 1:
        answer += 1
    elif num > 1:
        heapq.heappush(over, - num)
    else:
        heapq.heappush(under, num)


while over:
    cur = - heapq.heappop(over)
    if over:
        next = - heapq.heappop(over)
        answer += cur * next
    else:
        answer += cur


while under:
    cur = heapq.heappop(under)
    if under:
        next = heapq.heappop(under)
        answer += cur * next
    else:
        answer += cur


print(answer)
