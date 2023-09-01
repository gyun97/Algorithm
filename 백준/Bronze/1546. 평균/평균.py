import sys

N = int(sys.stdin.readline().strip())

score = list(map(int, sys.stdin.readline().split()))

max_score = max(score)

for i in range(N):
    score[i] = score[i]/max_score*100

print(sum(score)/len(score))