import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

//        System.out.println(Arrays.toString(A));

        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + A[i], A[i]);
            max = Math.max(max, dp[i]);
        }

//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
        

    }
}
