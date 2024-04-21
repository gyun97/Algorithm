import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static int T, N, M, K;
    static int[][] graph;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());


        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());  // 가로
            N = Integer.parseInt(st.nextToken());  // 세로
            K = Integer.parseInt(st.nextToken());

            graph = new int[N][M];

            count = 0;

            while (K --> 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());  // 가로
                int Y = Integer.parseInt(st.nextToken());  // 세로
                graph[Y][X] = 1;
            }
//            Arrays.stream(graph).flatMapToInt(i -> Arrays.stream(i)).forEach(System.out::println);


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void bfs(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        graph[i][j] = 0;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int[] dy = {1, -1, 0, 0}; // 세로
            int[] dx = {0, 0, 1, -1}; // 가로
            for (int k = 0; k < 4; k++) {
                int ny = currentPoint.x + dy[k];  // 행
                int nx = currentPoint.y + dx[k];  // 열
                if ((0 <= ny && ny < N) && (0 <= nx && nx < M) && (graph[ny][nx] == 1)) {
                    queue.add(new Point(ny, nx));
                    graph[ny][nx] = 0;
                }
            }

        }

    }
}