import sys

N, K = map(int, sys.stdin.readline().split())

HP_list = list(sys.stdin.readline().strip())  

count = 0

for i in range(N):  
    if HP_list[i] == "P":
        start = max(0, i - K)  # 음수 인덱스 방지
        end = min(N, i + K + 1)  # 리스트의 범위 초과 방지
        for j in range(start, end):
            if HP_list[j] == "H":
                count += 1
                HP_list[j] = "taken"
                break


print(count)




