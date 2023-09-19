while True:
    sum = 0
    yak_su = []
    n = int(input())
    if n == -1:
        break

    for i in range(1, n):
        if n % i == 0:
            yak_su.append(i)
            sum += i

    if n == sum:
        result = " + ".join(map(str, yak_su))
        print("{} = {}".format(n, result))
    else:
        print(f"{n} is NOT perfect.")
