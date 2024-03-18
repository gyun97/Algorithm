import sys

N = int(sys.stdin.readline().strip())

home_map = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]

count = 0   # 단지 내 집의 수

# 상하좌우 1칸씩 이동
dx = [1, -1, 0, 0]  # 상하 
dy = [0, 0, 1, -1]  # 좌우

home_block = []     # 각 단지 내 집의 수를 저장할 리스트


def dfs(x, y):
    """깊이 우선 탐색을 통해 단지 내 집의 수를 구하는 함수"""
    global count    # 함수 내에서 전역변수 count를 사용하겠다는 의미
    if x < 0 or x >= N or y < 0 or y >= N or home_map[x][y] == 0:  # 범위를 벗어나거나 집이 없으면   
        return      # 함수 종료
    count += 1      # 집이 있으면 count에 1을 더해 해당 단지의 집 개수 카운팅
    home_map[x][y] = 0  # 방문한 집은 0으로 초기화해 재방문 안 하게 방문 표시
    for i in range(4):      # 상하좌우 1칸씩 이동
        nx = x + dx[i]
        ny = y + dy[i]
        dfs(nx, ny)     # 재귀함수로 깊이 우선 탐색


for i in range(N):
    for j in range(N):
        if home_map[i][j] == 1:     # 집이 있으면
            dfs(i, j)   
            home_block.append(count)   # 단지 내 집의 수를 리스트에 저장
            count = 0   # 다음 단지의 집의 수를 구하기 위해 count 초기화


print(len(home_block))

home_block.sort()   # 오름차순 정렬

for k in home_block:    # 각 단지 내 집의 수 출력
    print(k)

