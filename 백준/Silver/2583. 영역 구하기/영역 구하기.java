import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 행
        N = Integer.parseInt(st.nextToken()); // 열
        K = Integer.parseInt(st.nextToken()); // 내부 직사각형 개수

        area = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            areaSplit(x1, y1, x2, y2);
        }

        visited = new boolean[M][N];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && area[i][j] == 0) {
                    int result = dfs(i, j);
                    results.add(result);

                }
            }
        }
        Collections.sort(results);

        System.out.println(results.size());
        results.forEach(i -> System.out.print(i + " "));
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N) {
                if (!visited[nx][ny] && area[nx][ny] == 0) {
                    size += dfs(nx, ny);
                }
            }
        }
        return size;

    }

    private static void areaSplit(int x1, int y1, int x2, int y2) {
        for (int y = y1; y < y2; y++) {
            for (int x = x1; x < x2; x++) {
                area[y][x] = 1;
            }
        }


    }
}


