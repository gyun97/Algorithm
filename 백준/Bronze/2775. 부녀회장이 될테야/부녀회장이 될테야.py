T = int(input())

for _ in range(T):
    k = int(input())  # 층
    n = int(input())  # 호
    apart = [[0] * n for _ in range(k + 1)]
    for i in range(k + 1):
        apart[i][0] = 1

    for j in range(n):
        apart[0][j] = j + 1

    for x in range(1, k + 1):
        for y in range(1, n):
            apart[x][y] = sum(apart[x - 1][:y + 1])
    print(apart[k][n-1])





