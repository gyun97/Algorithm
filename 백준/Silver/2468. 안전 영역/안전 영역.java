import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    static int N;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        area = new int[N][N];
        int highest = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                highest = Math.max(area[i][j], highest);
            }
        }

        int maxCount = 0;

        for (int height = 0; height < highest; height++) {
            visited = new boolean[N][N];
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && area[j][k] > height) {
                        dfs(j, k, height);
                        count++;
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);


    }

    private static void dfs(int x, int y, int height) {
        Point currentPoint = new Point(x, y);
        for (int i = 0; i < 4; i++) {
            int nx = currentPoint.x + dx[i];
            int ny = currentPoint.y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (!visited[nx][ny] && area[nx][ny] > height) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, height);
                }
            }

        }
    }


}
