import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    static int N;
    static String[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            String[] a = br.readLine().split("");
            grid[i] = a;
            Arrays.toString(a);
        }


        String[] a = {"a", "a", "a", "b"};



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j);

                }

            }

        }
        sb.append(count + " ");
        visited = new boolean[N][N];
        count = 0;



        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j].equals("G")) grid[i][j] = "R";
            }
        }

//        System.out.println(Arrays.deepToString(grid));




        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (!visited[i][j]) {
                    count++;
                    bfs(i, j);

                }

            }
        }

        sb.append(count);
        System.out.println(sb);




    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (0 > nx || nx >= N || 0 > ny || ny >= N || visited[nx][ny]) continue;
                if (grid[nx][ny].equals(grid[current.x][current.y])) {
                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }

        }
    }


}
