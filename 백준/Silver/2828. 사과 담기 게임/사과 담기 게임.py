import sys

input = sys.stdin.readline

N, M = map(int, input().split())

J = int(input().strip())

drop = [int(input().strip()) for _ in range(J)]

count = 0

left_edge = 1

right_edge = M

current_posi = 1

for i in range(J):
    current = drop[i]
    if left_edge <= current <= right_edge:  # 경우 1: 바구니 범위 앞으로 떨어져 가만히 있어도 되는 경우
        continue

    elif current > right_edge:  # 경우 2: 오른쪽으로 이동해야 하는 경우
        count += current - right_edge
        right_edge = current
        left_edge = (current - M) + 1

    elif current < left_edge:  # 경우 3: 왼쪽으로 이동해야 하는 경우
        count += left_edge - current
        left_edge = current
        right_edge = (current + M) - 1

print(count)









