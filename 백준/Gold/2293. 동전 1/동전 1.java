import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1]; // dp[i] = i원을 만들 수 있는 경우의 수
        dp[0] = 1;  // 0원을 만드는 경우는 아무 동전도 사용하지 않는 1가지

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = dp[i] + dp[i - coin]; // dp[i] : dp[i] = 기존 i원을 만들 수 있는 경우의 수,  dp[i - coin] : coin 원을 사용하기 전까지 만들 수 있는 조합의 수
            }

        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[k]);
    }




}


