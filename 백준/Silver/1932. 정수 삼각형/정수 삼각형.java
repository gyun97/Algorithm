import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] triangles = new int[N][];
        int[][] dp = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangles[i] = new int[i + 1];
            dp[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangles[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = 0;
            }
        }

        // Bottom-Up 방식을 위해 맨 아래 dp는 해당 칸의 삼각형 값으로 초기화
        // Top-Down 방식을 사용하면 같은 노드를 여러 번 방문해야 하고 메모제이션을 통해 중간중간 결과 저장과정 필요
        for (int i = 0; i < N; i++) {
            dp[N - 1][i] = triangles[N - 1][i];
        }

//        System.out.println(Arrays.deepToString(triangles));
//        System.out.println(Arrays.deepToString(dp));

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangles[i][j];

            }
        }

        bw.write(dp[0][0] + "\n");
        bw.flush();
        bw.close();
        

        

    }
}
