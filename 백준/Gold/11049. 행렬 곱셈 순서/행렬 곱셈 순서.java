import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과를 한 번에 출력하기 위해 StringBuilder 사용
        StringBuilder sb = new StringBuilder();

        // 행렬의 개수 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 행렬의 크기를 저장할 배열 (N개의 행렬이므로, 크기를 N+1로 설정)
        int[][] matrix = new int[N + 1][2];

        // 최소 곱셈 연산 횟수를 저장할 DP 테이블 (N+1 x N+1 크기)
        int[][] dp = new int[N + 1][N + 1];

        // 행렬의 크기 입력 받기
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // 행렬의 행(row) 크기
            matrix[i][1] = Integer.parseInt(st.nextToken()); // 행렬의 열(column) 크기
        }

        // 행렬 체인 곱셈의 최소 연산 횟수를 구하는 DP 수행
        // len: 현재 고려하는 행렬 곱셈의 길이 (2개부터 N개까지)
        for (int len = 2; len <= N; len++) {
            // i: 시작 행렬의 인덱스
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1; // 끝 행렬의 인덱스
                dp[i][j] = Integer.MAX_VALUE; // 최소값을 찾기 위해 초기값을 최댓값으로 설정

                // k: 행렬을 나누는 위치 (i <= k < j)
                for (int k = i; k < j; k++) {
                    // 현재 분할 위치(k)에서 곱셈 연산 비용 계산
                    int cost = dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]);
                    // 최소 연산 횟수 업데이트
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // 최소 연산 횟수를 StringBuilder에 저장 후 출력
        sb.append(dp[1][N]);
        System.out.println(sb);
    }
}
