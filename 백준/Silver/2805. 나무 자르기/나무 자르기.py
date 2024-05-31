import sys

input = sys.stdin.readline

N, M = map(int, input().split())

trees = sorted(list(map(int, input().split())))

first = 0
last = trees[-1]


def binary_search(first, last, M):

    while first <= last:
        mid = (first + last) // 2
        total_cut = 0
        for tree in trees:
            if mid < tree:
                total_cut += tree - mid

        if total_cut < M:
            last = mid - 1
        else:
            first = mid + 1

    return last


print(binary_search(first, last, M))

