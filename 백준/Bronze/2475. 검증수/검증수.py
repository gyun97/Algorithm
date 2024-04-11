nums = list(map(int, input().split()))

answer = sum(map(lambda x : x ** 2, nums))

print(answer % 10)