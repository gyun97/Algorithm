import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] order; // 입력된 수열
    static int[] dp; // 메모이제이션을 위한 배열
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 수열의 크기
        order = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
            dp[i] = -1; // 초기화 (아직 계산되지 않음을 의미)
        }

        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, findLDS(i));
        }

        System.out.println(maxLength);
    }

    // Top-Down 방식: i번째 요소를 포함하는 감소하는 부분 수열의 최장 길이 계산
    private static int findLDS(int idx) {
        if (dp[idx] != -1) return dp[idx]; // 이미 계산된 값이면 그대로 반환

        dp[idx] = 1; // 자기 자신만 포함하는 경우 최소 길이는 1
        for (int prev = 0; prev < idx; prev++) {
            if (order[prev] > order[idx]) { // 감소하는 관계가 성립하면
                dp[idx] = Math.max(dp[idx], findLDS(prev) + 1);
            }
        }
        return dp[idx]; // 해당 인덱스에서의 최장 감소 부분 수열 길이 반환
    }
}
