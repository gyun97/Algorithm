import sys

stack = []

N = int(sys.stdin.readline())

for _ in range(N):
    stack_order, *args = list(map(str, sys.stdin.readline().split()))

    if stack_order == "push":
        X = int(args[0])
        stack.append(int(X))

    elif stack_order == "pop":
        if len(stack) != 0:
            print(stack.pop())
        else:
            print("-1")
    elif stack_order == "size":
        print(len(stack))
    elif stack_order == "empty":
        if len(stack) == 0:
            print("1")
        else:
            print("0")
    elif stack_order == "top":
        if len(stack) != 0:
            print(stack[-1])
        else:
            print("-1")
