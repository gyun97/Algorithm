N = int(input())

rope = [int(input()) for _ in range(N)]

rope.sort()

results = []

for i in rope:
    current = N * i
    results.append(current)
    N -= 1

print(max(results))