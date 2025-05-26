import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, max;
    static int[][] paper;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        paper = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
                checkTShape(i, j);
            }
        }
        sb.append(max);
        System.out.println(sb);

    }

    private static void checkTShape(int x, int y) {
        int[][][] tShape = {
                {{0, 0}, {-1, 0}, {0, 1}, {0, -1}}, // ㅗ
                {{0, 0}, {1, 0}, {0, 1}, {0, -1}}, // ㅜ
                {{0, 0}, {1, 0}, {-1, 0}, {0, -1}}, // ㅓ
                {{0, 0}, {1, 0}, {-1, 0}, {0, 1}} // ㅏ
        };

        for (int i = 0; i < 4; i++) {
            int tempSum = 0;
            for (int j = 0; j < 4; j++) {
                int nx = x + tShape[i][j][0];
                int ny = y + tShape[i][j][1];
                if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                    break;
                }
                tempSum += paper[nx][ny];
            }
            max = Math.max(max, tempSum);
        }

    }

    private static void dfs(int x, int y, int depth, int sum) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[x][y] = true;

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                continue;
            }
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }
        }

    }
}




