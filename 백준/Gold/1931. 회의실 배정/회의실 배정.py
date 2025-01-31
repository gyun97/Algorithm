import sys
input = sys.stdin.readline

N = int(input())
graph = [list(map(int, (input().split()))) for _ in range(N)]
graph.sort(key=lambda x: (x[1], x[0]))

count = 0
prev_end = 0

for start, end in graph:
    if prev_end <= start:
        count += 1
        prev_end = end

print(count)









