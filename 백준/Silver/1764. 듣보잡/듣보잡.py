N, M = map(int, input().split())

a = {input() for _ in range(N)}  # 듣
b = {input() for _ in range(M)}  # 보

answer = a&b
answer = sorted(answer)
print(len(answer))
print(*answer, sep="\n")

