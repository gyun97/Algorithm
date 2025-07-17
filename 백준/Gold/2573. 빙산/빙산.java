import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[][] iceBurg;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceBurg = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceBurg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int iceBurgNum = 0;

        while ((iceBurgNum = countIceBurgNum()) < 2) {
            if (iceBurgNum == 0) {
                time = 0;
                break;
            }

            melt();
            time++;
        }

        System.out.println(time);


    }

    private static int countIceBurgNum() {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceBurg[i][j] != 0 && !visited[i][j]) {
                    dfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;

    }

    private static void dfs(int x, int y, boolean[][] visited) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                continue;
            }

            if (iceBurg[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }

            dfs(nx, ny, visited);
        }
    }

    private static void melt() {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (iceBurg[x][y] != 0) {
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int zeroCount = 0;
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) continue;
                if (iceBurg[nx][ny] == 0 && !visited[nx][ny]) zeroCount++;

            }
            iceBurg[curX][curY] -= zeroCount;
            if (iceBurg[curX][curY] <= 0) iceBurg[curX][curY] = 0;
        }

    }


}
