import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int N;
    static char[][] grid;
    static boolean[][] visited;
    static int count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        visited = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            for (int j = 0; j < S.length(); j++) {
                grid[i][j] = S.charAt(j);
            }

        }
//        System.out.println(Arrays.deepToString(grid));

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j);
                }


            }

        }

        sb.append(count + " ");
        count = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') grid[i][j] = 'R';

            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count++;
                    dfs(i, j);
                }

            }
        }

        sb.append(count);

        System.out.println(sb);


            }

    private static void dfs(int x, int y) {
        char c = grid[x][y];
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) continue;
            if (c == grid[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }

        }

    }
}

