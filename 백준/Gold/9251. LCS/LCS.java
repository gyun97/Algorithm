import java.io.*;

public class Main {

    static String[] str1, str2;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str1 = br.readLine().split("");
        str2 = br.readLine().split("");

        int N = str1.length + 1;
        int M = str2.length + 1;

        dp = new int[M][N];

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                LCS(i, j);
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        bw.write(dp[M - 1][N - 1]+ "\n");
        bw.close();
    }

    private static void LCS(int i, int j) {
        if (str2[i - 1].equals(str1[j - 1])) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
//        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//        if (str2[i - 1].equals(str1[j - 1])) dp[i][j]++;
    }
}


