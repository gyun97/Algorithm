import sys

charge = int(sys.stdin.readline().strip())

count = 0

if charge != 1 and 3 != charge:
    if (charge % 5) % 2 != 0:
        count = (charge // 5) - 1
    else:
        count = (charge // 5)
    charge = charge - (count * 5)
    count += charge // 2
    print(count)
else:
    print(-1)

