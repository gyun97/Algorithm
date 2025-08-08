import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M;
    static int[][] paper;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (isExistCheese()) {
            boolean[][] airs = markOutsideAir(0, 0);
            meltCheese(airs);
            time++;
        }

        System.out.println(time);

    }

    // 외부공기 영역 표시
    private static boolean[][] markOutsideAir(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if ((0 > nx || nx >= N) || (0 > ny || ny >= M) || paper[nx][ny] != 0 || visited[nx][ny]) continue;
                q.add(new int[]{nx, ny});
                visited[nx][ny] = true;

            }

        }
        return visited;
    }

    // 녹일 수 있는 치즈 녹이는 함수
    private static void meltCheese(boolean[][] visited) {
//        List<int[]> meltCheesesList = new ArrayList<>();

        int[][] temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            temp[i] = paper[i].clone();
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (paper[x][y] == 1) {
                    int airCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];

                        if (visited[nx][ny]) airCount++;
                    }

                    if (airCount >= 2) temp[x][y] = 0;
//                    if (airCount >= 2) meltCheesesList.add(new int[]{x, y});
                }
            }
        }

        paper = temp;
//        for (int[] pos : meltCheesesList) {
//            paper[pos[0]][pos[1]] = 0;
//        }
    }

    // 치즈가 모두 녹았는지 확인하는 메서드
    private static boolean isExistCheese() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (paper[i][j] == 1) return true;
            }
        }
        return false;
    }

}





