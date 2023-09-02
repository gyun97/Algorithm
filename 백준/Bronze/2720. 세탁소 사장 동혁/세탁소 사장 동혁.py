T = int(input())
changes = [25, 10, 5, 1]

for _ in range(T):
    C = int(input())
    for change in changes:
        print(C//change, end=" ")
        C = C%change
    print("")
