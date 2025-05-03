import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Integer>[] triangles = new ArrayList[N];
        List<Integer>[] dp = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            triangles[i] = new ArrayList<>();
            dp[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                triangles[i].add(Integer.parseInt(st.nextToken()));
                dp[i].add(0);
            }
        }

        for (int i = 0; i < N; i++) {
            dp[N - 1].set(i, triangles[N - 1].get(i));
        }

//        System.out.println(Arrays.toString(triangles));

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i].set(j, Math.max(dp[i + 1].get(j), dp[i + 1].get(j + 1)) + triangles[i].get(j));
            }
        }

//        System.out.println(Arrays.toString(dp));
        bw.write(dp[0].get(0) + "\n");
        bw.flush();
        bw.close();


    }
}
