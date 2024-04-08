N = int(input())

problems = list(input())


count = 1  # 맨 처음 전부 같은 색 칠하기

if problems.count("B") >= problems.count("R"):
    more_color = "B"
    less_color = "R"
else:
    more_color = "R"
    less_color = "B"


for i in range(N):
    prev = max(0, i - 1)
    if problems[i] == less_color and problems[i - 1] == more_color:
        count += 1

print(count)