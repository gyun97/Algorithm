# from sys import stdin
#
# N = int(stdin.readline().strip())
# schedule = []
#
#
# for _ in range(N):
#     start, finish = map(int, stdin.readline().split())
#     schedule.append((start, finish))
#
# print(schedule)
#
# minimum = schedule[0][1]
#
# for i in range(1, N):
#     if schedule[i][1] < minimum:
#         minimum = schedule[i][1]
#
# candidate_1 = []
#
# for j in range(N):
#     if minimum < j:
#         candidate_1.append(j)

from sys import stdin

N = int(stdin.readline().strip())

times = list(map(int, stdin.readline().split()))

sorted_times = sorted(times)


i = 0
j = 0

for time in sorted_times:
    i += time
    j += i
    
print(j)

