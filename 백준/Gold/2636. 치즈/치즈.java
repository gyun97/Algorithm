import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 판의 세로 길이
        M = Integer.parseInt(st.nextToken()); // 판의 가로 길이
        board = new int[N][M]; // 치즈가 놓여 있는 판
//        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCheese = 0;
        while (true) {
            List<int[]> toMelt = bfs(0, 0);
            if (toMelt.size() == 0) break;
            else lastCheese = toMelt.size();

            for (int[] pos : toMelt) {
                board[pos[0]][pos[1]] = 0;
            }
            time++;

        }

        System.out.println(time);
        System.out.println(lastCheese);

    }

    private static List<int[]> bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> toMelt = new ArrayList<>();
        boolean[][] visited = new boolean[N][M];

        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if (0 > nx || nx >= N || 0 > ny || ny >= M || visited[nx][ny]) continue;

                if (board[nx][ny] == 1) toMelt.add(new int[]{nx, ny});
                else if (board[nx][ny] == 0) q.add(new int[]{nx, ny});

                visited[nx][ny] = true;
            }

        }
        return toMelt;
    }


}