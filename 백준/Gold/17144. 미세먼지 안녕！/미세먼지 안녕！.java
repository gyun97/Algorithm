import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, T;
    static int[][] map;
    static int[] airCleaner = new int[2]; // [0]: 위쪽, [1]: 아래쪽
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int airIdx = 0;

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    airCleaner[airIdx++] = i;
                }
            }
        }

        while (T-- > 0) {
            spreadDust();
            operateAirCleaner();
        }

        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) total += map[i][j];
            }
        }

        System.out.println(total);
    }

    static void spreadDust() {
        int[][] tmp = new int[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    int spread = map[x][y] / 5;
                    int count = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
                        tmp[nx][ny] += spread;
                        count++;
                    }
                    tmp[x][y] -= spread * count;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += tmp[i][j];
            }
        }
    }

    static void operateAirCleaner() {
        int top = airCleaner[0];
        int bottom = airCleaner[1];

        // 위쪽 반시계 방향
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0;

        // 아래쪽 시계 방향
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }
}
