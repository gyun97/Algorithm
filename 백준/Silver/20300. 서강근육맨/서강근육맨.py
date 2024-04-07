import sys

N = int(sys.stdin.readline().strip())

loss = list(map(int, sys.stdin.readline().split()))

loss.sort()

# print(loss)

loss_sum = []

count = len(loss) // 2


for i in range(count):
    if len(loss) % 2 != 0:
        loss_sum.append(loss[i] + loss[-2 - i])
    else:
        loss_sum.append(loss[i] + loss[-1 - i])

if len(loss_sum) % 2 == 0:
    loss_sum.append(loss[-1])


print(max(loss_sum))