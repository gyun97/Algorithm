import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int M, N;
    static int[][] tomato;
    static Queue<Point> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    queue.add(new Point(i, j));
                }
            }
        }

        bfs();
//        System.out.println(Arrays.deepToString(tomato));

        int day = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    sb.append(-1);
                    System.out.println(sb);
//                    System.exit(0);
                    return;
                } else {
                    day = Math.max(day, tomato[i][j]);

                }
            }
        }

        sb.append(day - 1);
        System.out.println(sb);

    }

    public static void bfs(){
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];
                if ((0 <= nx && nx < N) && (0 <= ny && ny < M) && (tomato[nx][ny] == 0)) {
                    queue.add(new Point(nx, ny));
                    tomato[nx][ny] = tomato[currentPoint.x][currentPoint.y] + 1;

                }
            }

        }


    }

}