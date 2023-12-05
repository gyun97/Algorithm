from sys import stdin


def factorial(N):
    if N <= 1:
        return 1

    return N * factorial(N-1)

N = int(stdin.readline().strip())
print(factorial(N))
