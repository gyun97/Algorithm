import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N, K;
    static int[][] board;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 내부 직사각형 개수

        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            boardSplit(x1, y1, x2, y2);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    int reuslt = dfs(i, j);
                    results.add(reuslt);
                }

            }
        }

        Collections.sort(results);

        sb.append(results.size()).append("\n");

        for (Integer result : results) {
            sb.append(result).append(" ");
        }

        System.out.println(sb);
    }

    private static int dfs(int x, int y) {
        board[x][y] = 1;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 > nx || nx >= M || 0 > ny || ny >= N) {
                continue;
            }

            if (board[nx][ny] == 0) {
                size += dfs(nx, ny);
            }
        }
        return size;
    }

    private static void boardSplit(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                board[y][x] = 1;
            }

        }
    }
}


