import sys

N = int(sys.stdin.readline())

my_cards = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
check_cards = list(map(int, sys.stdin.readline().split()))

dict = {}
for i in range(len(my_cards)):
    dict[my_cards[i]] = 0

for j in range(M):
    if check_cards[j] not in dict:
        print(0, end=' ')
    else:
        print(1, end=' ')