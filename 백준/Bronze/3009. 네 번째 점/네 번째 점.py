import sys

list_x = []
list_y = []

for _ in range(3):
    x, y = map(int, sys.stdin.readline().split())
    list_x.append(x)
    list_y.append(y)

for x, y in zip(list_x, list_y):
    if list_x.count(x) == 1:
        last_x = x
    if list_y.count(y) == 1:
        last_y = y

print(last_x, last_y)