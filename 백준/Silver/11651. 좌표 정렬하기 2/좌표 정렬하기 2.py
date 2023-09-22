import sys

N = int(sys.stdin.readline().strip())

list_x = []
list_y = []
list_dots = []

for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    list_x.append(x)
    list_y.append(y)

for x, y in zip(list_x, list_y):
    list_dots.append([x,y])

list_dots = sorted(list_dots, key = lambda dot : (dot[1], dot[0]))

for dot in list_dots:
    print(*dot)