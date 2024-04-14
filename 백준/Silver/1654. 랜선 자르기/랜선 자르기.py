import sys

N, K = map(int, sys.stdin.readline().split())

lans = [int(sys.stdin.readline().strip()) for _ in range(N)]

# 백준 1654번 문제에서 이분 탐색 쓰는 이유는? : 이분 탐색은 최적화 문제를 해결할 때 사용한다.
# 최적화 문제란? : 최적화 문제는 여러 해답 중 하나를 선택해야 할 때, 그 해답을 찾는 문제이다.
# 최적화 문제의 특징 : 최적화 문제는 문제의 조건을 만족하는 해가 여러 개일 수 있다. 이 때, 이분 탐색을 사용하면 효과적으로 해결할 수 있다.

lans.sort()

def binary_search(lans, K):
    start = 1
    end = lans[-1]

    while start <= end:
        mid = (start + end) // 2
        count = 0

        for lan in lans:
            count += lan // mid

        if count >= K:
            start = mid + 1
        else:
            end = mid - 1

    return end


print(binary_search(lans, K))


