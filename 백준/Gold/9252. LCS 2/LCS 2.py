import sys
input = sys.stdin.readline

str1 = input().strip()
str2 = input().strip()

# ✅ dp 배열 올바르게 초기화
dp = [[0] * (len(str2) + 1) for _ in range(len(str1) + 1)]

# ✅ DP 테이블 채우기
for i in range(1, len(str1) + 1):
    for j in range(1, len(str2) + 1):
        if str1[i - 1] == str2[j - 1]:
            dp[i][j] = dp[i - 1][j - 1] + 1
        else:
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

# ✅ LCS 추적
i, j = len(str1), len(str2)
answer = []

while i > 0 and j > 0:
    if str1[i - 1] == str2[j - 1]:
        answer.append(str1[i - 1])
        i -= 1
        j -= 1
    elif i > 0 and dp[i - 1][j] >= dp[i][j - 1]:  # ✅ i가 0보다 클 때만 검사
        i -= 1
    elif j > 0:  # ✅ j가 0보다 클 때만 검사
        j -= 1

# ✅ 결과 출력
print(dp[len(str1)][len(str2)])
print("".join(answer[::-1]))  # 🔹 LCS는 뒤집어서 출력해야 함!
