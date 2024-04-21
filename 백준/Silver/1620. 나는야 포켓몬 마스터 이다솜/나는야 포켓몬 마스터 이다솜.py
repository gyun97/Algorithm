import sys

input = sys.stdin.readline

N, M = map(int, input().split())

dogam = dict()

names = []

for i in range(1, N + 1):
    name = input().strip()
    dogam[name] = i
    names.append(name)

for j in range(M):
    q = input().strip()
    try:
        q = int(q)
        print(names[q - 1])
    except:
        print(dogam[q])




