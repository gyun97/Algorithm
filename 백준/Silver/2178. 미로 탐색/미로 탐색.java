import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] graph;
    static boolean[][] visited;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }

        }
//        System.out.println(Arrays.deepToString(graph));
        queue = new ArrayDeque<>();
        bfs(0, 0);

        System.out.println(graph[N - 1][M - 1]);

    }

    private static void bfs(int x, int y) {
        queue.add(new Point(x, y));
        visited[x][y] = true;

        int[] dx = {1, -1, 0, 0}; // 상하
        int[] dy = {0, 0, 1, -1}; // 좌우

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
//                if ((0 <= nx && nx < N && 0 <= ny && ny < M) && !visited[nx][ny] && graph[nx][ny] == 1) {
                if ((0 > nx || nx >= N || 0 > ny || ny >= M) || visited[nx][ny] || graph[nx][ny] == 0) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                graph[nx][ny] = graph[currentX][currentY] + 1;
            }
        }

    }

}


