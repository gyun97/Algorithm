import sys
sys.setrecursionlimit(10^6)
input = sys.stdin.readline

N = int(input())

paper = [list(map(int, input().split())) for _ in range(N)]

# print(paper)

count_0 = 0
count_1 = 0


def divide(x, y, N):
    global count_0, count_1
    first = paper[x][y]
    for i in range(x, x + N):
        for j in range(y, y + N):
            if first != paper[i][j]:
                divide(x, y, N // 2)
                divide(x, y + N // 2, N // 2)
                divide(x + N // 2, y, N // 2)
                divide(x + N // 2, y + N // 2, N // 2)
                return

    if first == 0:
        count_0 += 1
    else:
        count_1 += 1

divide(0, 0, N)
print(count_0)
print(count_1)



