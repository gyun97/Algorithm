import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Nation {
    int x; // 행
    int y; // 열
    int population; // 인구

    public Nation(int x, int y, int population) {
        this.x = x;
        this.y = y;
        this.population = population;
    }

}

public class Main {
    static int N, L, R, count;
    static int[][] nations;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 줄 개수
        L = Integer.parseInt(st.nextToken()); // 최소 인구 격차
        R = Integer.parseInt(st.nextToken()); // 최대 인구 격차

        nations = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nations[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 0;

        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        boolean result = bfs(i, j, visited);
                        if (result) moved = true;
                    }
                }
            }

            if (!moved) break;
            count++;
        }


//        System.out.println(Arrays.deepToString(nations));
        System.out.println(count);
    }

    private static boolean bfs(int r, int c, boolean[][] visited) {
        Queue<Nation> q = new LinkedList<>();
        List<Nation> unions = new ArrayList<>();

        boolean flag = false;

        q.add(new Nation(r, c, nations[r][c]));
        visited[r][c] = true;
        unions.add(new Nation(r, c, nations[r][c]));

        while (!q.isEmpty()) {
            Nation cur = q.poll();


            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(cur.population - nations[nx][ny]);
                    if (diff >= L && diff <= R) {
                        q.add(new Nation(nx, ny, nations[nx][ny]));
                        visited[nx][ny] = true;
                        unions.add(new Nation(nx, ny, nations[nx][ny]));
                        flag = true;
                    }

                }
            }
        }

        if (!flag) return false;

        int sum = 0;
        for (Nation nation : unions) {
            sum += nation.population;
        }

//        unions.stream().forEach(i -> System.out.println(i.population));

//        System.out.println("sum = " + sum);

        int avg = sum / unions.size();

//        System.out.println("avg = " + avg);

        for (Nation nation : unions) {
            nations[nation.x][nation.y] = avg;
        }

        return true;
    }

}









