import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())
parent = [0] * (n + 1)


for i in range(n + 1):
    parent[i] = i


def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]


def union(a, b):
    a = find(a)
    b = find(b)

    if a != b:
        if a < b:
            parent[b] = a
        else:
            parent[a] = b


def check_same(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return True
    else:
        return False


for _ in range(m):
    cond, a, b = map(int, input().split())
    if cond == 0:
        union(a, b)
    else:
        if check_same(a,b):
            print("YES")
        else:
            print("NO")










