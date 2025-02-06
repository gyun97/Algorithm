import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] order = new int[N]; // 수열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N]; // 각 수열의 자리 수가 가질 수 있는 가장 긴 부분 수열의 길이
        Arrays.fill(dp, 1); // 초기값은 자기 자신이 포함된 1

        for (int i = 0; i < N; i++) { // 계산할 자리 수
            for (int j = i - 1; j >= 0; j--) { // 자리 수 i의 이전 수들
                if (order[i] < order[j]) { // 만약 이전 수인 j가 나중의 수인 i보다 더 크다면 감소하는 부분 수열이 성립된다.
                    dp[i] = Math.max(dp[i], dp[j] + 1); // (j가 가질 수 있는 최대의 수열의 길이에다가 i를 포함하여 + 1한 수)와 (기존 i의 부분 수열의 최대 길이 비교)
                }
            }
        }

        sb.append(Arrays.stream(dp).max().getAsInt()); // 각 수열의 자리 수가 가질 수 있는 가장 긴 부분 수열의 길이의 모음인 dp 중에서 가장 긴 부분 수열의 길이 추출
        System.out.println(sb);

    }
}
