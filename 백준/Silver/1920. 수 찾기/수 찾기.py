from sys import stdin

N = int(stdin.readline())

A = list(map(int, stdin.readline().split()))

M = int(stdin.readline())

integer = list(map(int, stdin.readline().split()))

A = sorted(A)

for target in integer:
    first_idx = 0
    last_idx = N - 1
    target_exist = False

    while first_idx <= last_idx:
        middle_idx = (first_idx + last_idx) // 2
        if target == A[middle_idx]:
            print(1)
            target_exist = True
            break
        elif target > A[middle_idx]:
            first_idx = middle_idx + 1
        else:
            last_idx = middle_idx - 1

    if not target_exist:
        print(0)







