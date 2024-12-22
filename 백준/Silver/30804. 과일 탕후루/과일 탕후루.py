import sys
input = sys.stdin.readline

N = int(input())
fruits = list(map(int, input().split()))
count = {}
answer = 0
left = 0

for right in range(N):
    if fruits[right] in count:
        count[fruits[right]] += 1
    else:
        count[fruits[right]] = 1

    while len(count) > 2:
        count[fruits[left]] -= 1
        if count[fruits[left]] == 0:
            del count[fruits[left]]
        left += 1

    answer = max(answer, right - left + 1)

print(answer)















