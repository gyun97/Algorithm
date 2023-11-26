from sys import stdin


N = int(stdin.readline().strip())

for _ in range(N):
    stack = []
    vps = stdin.readline().strip()
    for i in range(len(vps)):
        char = vps[i]
        if char == "(":
            stack.append(char)

        else:
            if len(stack) != 0 and stack[-1] == "(":
                stack.pop()
            else:
                stack.append(char)

    print("YES") if len(stack) == 0 else print("NO")

