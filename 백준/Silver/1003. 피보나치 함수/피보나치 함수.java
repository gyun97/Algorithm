import java.io.*;

public class Main {

    static Integer[][] dp = new Integer[41][2]; // [n, 0 출력 횟수, 1 출력 횟수]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        dp[0][0] = 1; // N = 0일 때, 0 호출 횟수
        dp[0][1] = 0; // N = 0일 때, 1 호출 횟수
        dp[1][0] = 0; // N = 1일 때, 0 호출 횟수
        dp[1][1] = 1; // N = 1일 때, 1 호출 횟수

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibonacci(N);
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static Integer[] fibonacci(int N) {
        if (dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }

        return dp[N];
    }

}

