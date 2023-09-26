import sys

N = int(sys.stdin.readline().strip())

info = []

for _ in range(N):
    age, name = map(str, sys.stdin.readline().split())
    info.append([int(age),name])

info = sorted(info, key= lambda k : k[0])

for i in range(N):
    print(info[i][0], info[i][1])