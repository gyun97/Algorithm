import sys

A, B, V = map(int, sys.stdin.readline().split())


if (V - B) % (A - B) == 0:
    print((V - B) // (A - B))
else:
    print((V - B) // (A - B) + 1)
