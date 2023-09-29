n = int(input())
queue = list(map(int, input().split()))
stack = []
min_num = 1

while queue:
    if queue[0] == min_num:
        queue.pop(0)
        min_num += 1
    else:
        stack.append(queue.pop(0))

    while stack:
        if stack[-1] == min_num:
            stack.pop()
            min_num += 1
        else:
            break

if not stack:
    print('Nice')
else:
    print('Sad')