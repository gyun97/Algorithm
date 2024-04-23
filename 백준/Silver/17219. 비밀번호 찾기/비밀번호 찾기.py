import sys

input = sys.stdin.readline

N ,M = map(int, input().split())

dic = dict()

for _ in range(N):
    key, value = map(str, input().split())
    dic[key] = value

for _ in range(M):
    find = input().strip()
    answer = dic[find]
    print(answer)