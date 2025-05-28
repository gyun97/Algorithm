import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, r, c, d, count;
    static int[][] area;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()); // 행
        c = Integer.parseInt(st.nextToken()); // 열
        d = Integer.parseInt(st.nextToken()); // 방향

        area = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = 1;

//        System.out.println(Arrays.deepToString(area));
        clean(r, c, d);
        sb.append(count);
        System.out.println(sb);
    }

    private static void clean(int x, int y, int d) {
        area[x][y] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (area[nx][ny] == 0) {
                    count++;
                    clean(nx, ny, d);
                    return;
                }
            }

        }

        // 후
        int back = (d + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if (0 <= bx && bx < N && 0 <= by && by < M) {
            if (area[bx][by] != 1) {
                clean(bx, by, d);
            }
        }


    }


}





