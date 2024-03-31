import sys

N = int(sys.stdin.readline().strip())

meetings = []

for _ in range(N):
    meetings.append(list(map(int, sys.stdin.readline().split())))

meetings.sort(key = lambda x : (x[1], x[0]))


previous_end = 0

count = 0

for next_start, next_end in meetings:
    if previous_end <= next_start:
        count += 1
        previous_end = next_end

print(count)


