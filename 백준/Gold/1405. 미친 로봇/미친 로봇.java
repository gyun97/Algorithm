import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double answer;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static double[] prob = new double[4];
    static boolean[][] visited = new boolean[30][30];
    ;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) / 100.0;
        }

        visited[15][15] = true;
        dfs(15, 15, 0, 1.0);
        System.out.println(answer);
    }

    // 로봇 이동
    private static void dfs(int x, int y, int depth, double p) {
        if (depth == N) {
            answer += p;
            return;
        }

        for (int d = 0; d < 4; d++) {
            if (prob[d] == 0) continue;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, p * prob[d]);
                visited[nx][ny] = false;
            }

        }

    }



}
