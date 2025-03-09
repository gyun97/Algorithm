import java.io.*;

public class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        dp[1] = 1;
        dp[0] = 1;
        recur(N);

//        System.out.println(Arrays.toString(dp));

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

    public static int recur(int n) {
        if(dp[n] != 0) return dp[n];
        dp[n] = (recur(n - 1) + recur(n - 2)) % 10007;
        return dp[n];

    }
}






