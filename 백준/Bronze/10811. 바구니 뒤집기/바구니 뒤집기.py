import sys

N, M = map(int, sys.stdin.readline().split())

basket_list = [x for x in range(1,N+1)]  # [1,2,3,4,5]

for _ in range(M):
    i, j = map(int, sys.stdin.readline().split())
    basket_list[i-1:j] = basket_list[i-1:j][::-1]

print(*basket_list)