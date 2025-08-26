import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[][] board;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; // 행
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; // 열
    static boolean[][] cloud;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 격자의 행, 열
        M = Integer.parseInt(st.nextToken()); // 이동 명령 횟수
        board = new int[N + 1][N + 1];
        cloud = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // 해당 칸에 들어있는 물의 양
            }
        }

        cloud[N][1] = true;
        cloud[N][2] = true;
        cloud[N - 1][1] = true;
        cloud[N - 1][2] = true;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1; // 이동 방향
            int s = Integer.parseInt(st.nextToken()); // 이동 거리

            moving(d, s); // 1. 모든 구름이 di 방향으로 si칸 이동한다.
            List<int[]> cloudPos = raining();// 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            removeClouds(); // 3. 구름이 모두 사라진다.
            // 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
            copyWaterMagic(cloudPos);
            // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
            makeCloud(cloudPos);
        }

        System.out.println(calculateSum());

    }

    private static void makeCloud(List<int[]> cloudPos) {
        List<int[]> temp = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (board[i][j] >= 2) {
                    temp.add(new int[]{i, j});
                }
            }
        }

        List<int[]> list = new ArrayList<>();
        LOOP:
        for (int[] cur : temp) {
            for (int[] cloudPo : cloudPos) {
                if (cur[0] == cloudPo[0] && cur[1] == cloudPo[1]) {
                    continue LOOP;
                }
            }
            list.add(cur);
        }

        for (int[] cur : list) {
            int x = cur[0];
            int y = cur[1];
            cloud[x][y] = true;
            board[x][y] -= 2;
        }
    }

    private static void copyWaterMagic(List<int[]> cloudPos) {
        for (int[] cur : cloudPos) {
            int x = cur[0];
            int y = cur[1];
            int count = 0;
            int[] diagonal = {1, 3, 5, 7}; // 대각선 방향
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[diagonal[d]];
                int ny = y + dy[diagonal[d]];
                if (0 >= nx || nx > N || 0 >= ny || ny > N || board[nx][ny] == 0) {
                    continue;
                }
                count++;
            }
            board[x][y] += count;
        }
    }

    private static void removeClouds() {
        cloud = new boolean[N + 1][N + 1];
    }

    private static List<int[]> raining() {
        List<int[]> rememberCloud = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j]) {
                    board[i][j]++;
                    rememberCloud.add(new int[]{i, j});
                }
            }
        }
        return rememberCloud;
    }

    // 모든 칸에 있는 물의 양의 합 계산
    private static int calculateSum() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }


    private static void moving(int d, int s) {
        boolean[][] tempCloud = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j]) {
                    int nx = (i + dx[d] * s) % N;
                    int ny = (j + dy[d] * s) % N;
                    if (nx <= 0) nx += N;
                    if (ny <= 0) ny += N;
                    
                    tempCloud[nx][ny] = true;

                }
            }
        }
        cloud = tempCloud;

    }

}


