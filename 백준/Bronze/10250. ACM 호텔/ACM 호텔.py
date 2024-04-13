T = int(input().strip())

for _ in range(T):
    H, W, N = map(int, input().split())
    if N % H == 0:
        y = H
        x = N // H
    else:
        y = N % H
        x = N // H + 1
    if x < 10:
        x = "0" + str(x)
    else:
        x = str(x)
    answer = str(y) + x
    print(answer)



