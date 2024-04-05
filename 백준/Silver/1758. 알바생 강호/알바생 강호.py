import sys

N = int(sys.stdin.readline())

tips = [int(sys.stdin.readline()) for _ in range(N)]

tips.sort(reverse=True)

answer = 0

ranking = 1

for tip in tips:
    my_tip = tip - (ranking - 1)
    ranking += 1
    if my_tip > 0:
        answer += my_tip

print(answer)

