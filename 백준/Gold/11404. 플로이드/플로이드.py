import sys
input = sys.stdin.readline

n = int(input())  # 도시의 개수
m = int(input())  # 노선의 개수

inf = sys.maxsize

distance = [[inf for _ in range(n + 1)] for _ in range(n + 1)]
for i in range(1, n + 1):
    distance[i][i] = 0


for _ in range(m):
    start, end, weight = map(int, input().split())
    if distance[start][end] > weight:
        distance[start][end] = weight

for k in range(1, n + 1):
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            distance[i][j] = min(distance[i][j], distance[i][k] + distance[k][j])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if distance[i][j] == inf:
            print(0, end=" ")
        else:
            print(distance[i][j], end=" ")
    print()





