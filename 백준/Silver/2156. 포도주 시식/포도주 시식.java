import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] wines = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1){
            sb.append(wines[1]);
            System.out.println(sb);
            System.exit(0);
        } 
        
        if (N == 2) {
            sb.append(wines[1] + wines[2]);
            System.out.println(sb);
            System.exit(0);
        }


        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        int max = 0;

        /**
         *
         * dp[i]를 i번째 잔까지 고려했을 때, 마실 수 있는 최대 포도주 양이라고 하자.
         *
         * 선택지는 3가지야:
         * i번째 포도주 잔을 마시려면 이전 두 잔 중 하나는 건너뛰어야 해.
         *
         * i번째 잔을 마시지 않는다
         * → dp[i-1]
         *
         * i번째 잔만 마시고, i-1번째 잔은 건너뛴다
         * → dp[i-2] + wine[i]
         *
         * i번째 잔과 i-1번째 잔을 마시고, i-2번째 잔은 건너뛴다
         * → dp[i-3] + wine[i-1] + wine[i]
         */

        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + wines[i]), dp[i - 3] + wines[i] + wines[i - 1]);
            if (max < dp[i]) max = dp[i];
        }
        sb.append(max);
//        System.out.println(Arrays.toString(dp));
        System.out.println(sb);

    }
}
