import math

M = int(input())
N = int(input())

sum = 0
yak_su = []
for i in range(M, N+1):
    if i >= 2:
        for j in range(2, int(math.sqrt(i)) + 1):
            if i % j == 0:
                break
        else:
            sum += i
            yak_su.append(i)

print(sum) if yak_su else 0
print(min(yak_su)) if yak_su else print(-1)