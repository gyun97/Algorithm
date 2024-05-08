import sys
input = sys.stdin.readline

M = int(input())

S = set()

for _ in range(M):
    order = input().split()
    if order[0] == "add":
        S.add(int(order[1]))
    elif order[0] == "remove":
        S.discard(int(order[1]))
    elif order[0] == "check":
        if int(order[1]) in S:
            print(1)
        else:
            print(0)
    elif order[0] == "toggle":
        if int(order[1]) in S:
            S.remove(int(order[1]))
        else:
            S.add(int(order[1]))
    elif order[0] == "all":
        S = {x for x in range(1, 21)}
    elif order[0] == "empty":
        S.clear()






