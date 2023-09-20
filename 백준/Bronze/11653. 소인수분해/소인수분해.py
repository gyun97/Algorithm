N = int(input())
primes = []
i = 2

while True:
    if N % i == 0:
        primes.append(i)
        N = N // i
    else:
        i += 1

    if N == 1:
        break

for prime in primes:
    print(prime)