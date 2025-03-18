import sys

input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()

N = len(str1)
M = len(str2)

# dp 배열 크기 수정 (M+1) x (N+1)
dp = [[0] * (N + 1) for _ in range(M + 1)]

# dp 테이블 채우기
for i in range(1, M + 1):  # M을 사용
    for j in range(1, N + 1):  # N을 사용
        if str1[j - 1] == str2[i - 1]:  # 인덱스 수정
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

# LCS 길이 출력
answer = dp[M][N]  # 올바른 위치에서 LCS 길이 가져오기
print(answer)

# LCS 문자열 복원
if answer == 0:  # 정수값이므로 len() 대신 비교 연산
    sys.exit(0)

i = M
j = N
arr = []

while i > 0 and j > 0:  # IndexError 방지
    if str1[j - 1] == str2[i - 1]:  # 인덱스 수정
        arr.append(str1[j - 1])
        i -= 1
        j -= 1
    elif dp[i - 1][j] > dp[i][j - 1]:
        i -= 1
    else:
        j -= 1

# LCS 문자열 출력 (뒤집어서 출력)
print("".join(arr[::-1]))
