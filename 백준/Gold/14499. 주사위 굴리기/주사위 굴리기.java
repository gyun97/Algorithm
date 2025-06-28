import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[7]; // 1~6 사용 (0 안 씀)

    // 동, 서, 북, 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (K-- > 0) {
            int dir = Integer.parseInt(st.nextToken()) - 1; // 0부터 시작: 동서북남
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            roll(dir); // 주사위 회전

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[6]; // 바닥 -> 지도
            } else {
                dice[6] = map[nx][ny]; // 지도 -> 바닥
                map[nx][ny] = 0;
            }

            x = nx;
            y = ny;

            sb.append(dice[1]).append("\n"); // 윗면 출력

        }
        System.out.println(sb);
    }

    static void roll(int dir) {
        int[] temp = dice.clone();
        switch (dir) {
            case 0: // 동
                dice[1] = temp[4];
                dice[3] = temp[1];
                dice[6] = temp[3];
                dice[4] = temp[6];
                break;
            case 1: // 서
                dice[1] = temp[3];
                dice[4] = temp[1];
                dice[6] = temp[4];
                dice[3] = temp[6];
                break;
            case 2: // 북
                dice[1] = temp[5];
                dice[2] = temp[1];
                dice[6] = temp[2];
                dice[5] = temp[6];
                break;
            case 3: // 남
                dice[1] = temp[2];
                dice[5] = temp[1];
                dice[6] = temp[5];
                dice[2] = temp[6];
                break;
        }
    }
}
