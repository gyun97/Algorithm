N = int(input())
counts = []

# N = (5 * i) + (3 * j) 중  i+j의 최솟값

for i in range(N // 5 + 1):
    for j in range(N // 3 + 1):
        if 5 * i + 3 * j == N:
            counts.append(i + j)

if counts:
    print(min(counts))
else:
    print(-1)
