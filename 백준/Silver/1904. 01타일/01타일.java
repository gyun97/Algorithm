import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;

//        for (int i = 3; i < N + 1; i++) {
//            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
//        }
        IntStream.range(3, N + 1)
                .forEach(i -> dp[i] = (dp[i - 1] + dp[i - 2]) % 15746);

        System.out.println(dp[N]);
        
    }

}