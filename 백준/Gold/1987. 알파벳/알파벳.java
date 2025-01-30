import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, maxDepth;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // A-Z 방문 여부 체크
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        maxDepth = 0;
        dfs(0, 0, 1);
        System.out.println(maxDepth);
    }

    private static void dfs(int x, int y, int depth) {
        maxDepth = Math.max(maxDepth, depth); // 현재까지의 최대 깊이 갱신
        visited[board[x][y] - 'A'] = true; // 현재 위치의 알파벳 방문 체크

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (!visited[board[nx][ny] - 'A']) { // 새로운 알파벳이라면
                    dfs(nx, ny, depth + 1);
                }
            }
        }

        visited[board[x][y] - 'A'] = false; // 백트래킹 (방문 해제)
    }
}
