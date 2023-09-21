import sys

N = int(sys.stdin.readline().strip())

dot_list = []


for _ in range(N):
    x, y = map(int, sys.stdin.readline().split())
    dot_list.append([x,y])


dot_list = sorted(dot_list)  # sorted(이중 리스트): 첫 번째 요소의 크기를 기준으로 배열하고, 같으면 두 번째 요소 크기로 정렬

for dot in dot_list:
    print(*dot)