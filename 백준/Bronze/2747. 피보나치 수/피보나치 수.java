import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;

        fibonacci(n);
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);

    }

    public static int fibonacci(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

}