import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static final int[] dx = {-1, -2, -2, -1, 1, 2, 1, 2};
    static final int[] dy = {-2, -1, 1, 2, 2, 1, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            String[] input1 = br.readLine().split(" ");
            int firstX = Integer.parseInt(input1[0]);
            int firstY = Integer.parseInt(input1[1]);

            String[] input2 = br.readLine().split(" ");
            int endX = Integer.parseInt(input2[0]);
            int endY = Integer.parseInt(input2[1]);

            boolean[][] visited = new boolean[N][N];
            int[][] board = new int[N][N];
            bfs(N, firstX, firstY, endX, endY, visited, board);
        }
    }

    private static void bfs(int N, int firstX, int firstY, int endX, int endY, boolean[][] visited, int[][] board) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{firstX, firstY});
        visited[firstX][firstY] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            if (x == endX && y == endY) {
                System.out.println(board[x][y]);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        board[nx][ny] = board[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

    }

}







