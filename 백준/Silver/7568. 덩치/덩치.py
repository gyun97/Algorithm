import sys

N = int(sys.stdin.readline().strip())

a = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

result = []

for w_1, h_1 in a:
    count = 0
    for w_2, h_2 in a:
        if w_1 < w_2 and h_1 < h_2:
            count += 1
    result.append(count)

answer = list(map(lambda x: x + 1, result))
print(*answer)
