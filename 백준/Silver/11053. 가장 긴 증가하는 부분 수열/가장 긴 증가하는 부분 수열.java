import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        Arrays.fill(dp, 1);
        bw.write(LIS() + "\n");
        bw.flush();
        bw.close();

    }

    private static int LIS() {
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (A[i] < A[j]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1); // dp[j] = j번째 원소를 마지막 원소로 가지는 LIS의 길이
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }


}