import sys

square = [list(map(int, sys.stdin.readline().split())) for _ in range(3)]

if square[0][0] == square[1][0]:
    last_x = square[2][0]
elif square[1][0] == square[2][0]:
    last_x = square[0][0]
else:
    last_x = square[1][0]

if square[0][1] == square[1][1]:
    last_y = square[2][1]
elif square[1][1] == square[2][1]:
    last_y = square[0][1]
else:
    last_y = square[1][1]

square.append([last_x, last_y])

print(*square[3])