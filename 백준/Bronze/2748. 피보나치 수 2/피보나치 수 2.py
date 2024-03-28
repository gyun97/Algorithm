import sys

n = int(sys.stdin.readline().strip())


def fibo(n):
    fibo_table = [0, 1, 1]

    for i in range(3, n + 1):
        fibo_table.append(fibo_table[i - 1] + fibo_table[i - 2])

    return fibo_table[n]


print(fibo(n))