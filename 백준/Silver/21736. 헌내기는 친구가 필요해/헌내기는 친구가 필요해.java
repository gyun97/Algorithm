import java.awt.*;
import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class Main {

    static int N, M, count;
    static String[] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new String[N];
        visited = new boolean[N][M];
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = graph[i].charAt(j);
                if (c == 'I') {
                    x = i;
                    y = j;
                } else if (c == 'X') {
                    visited[i][j] = true;

                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.println(visited[i][j]);
//            }
//        }


        count = 0;
        bfs(x, y);
        if (count > 0) {
            sb.append(count);
        } else {
            sb.append("TT");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];
                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (!visited[nx][ny])) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                    if (graph[nx].charAt(ny) == 'P') {
                        count++;
                    }


                }
            }
        }

    }
}