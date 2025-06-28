import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[7];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기
        x = Integer.parseInt(st.nextToken()); // 주사위 처음 위치 x 좌표
        y = Integer.parseInt(st.nextToken()); // 주사위 처음 위치 y 좌표
        K = Integer.parseInt(st.nextToken()); // 명령의 개수

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());

            // 동으로 이동(y + 1)
            if (dir == 1) {
                if (y + 1 < M) {
                    y++;
                } else continue;
            // 서로 이동(y - 1)
            } else if (dir == 2) {
                if (y - 1 >= 0) {
                    y--;
                } else continue;
            // 북으로 이동(x - 1)
            } else if (dir == 3) {
                if (x - 1 >= 0) {
                    x--;
                } else continue;
            // 남으로 이동(x + 1)
            } else if (dir == 4) {
                if (x + 1 < N) {
                    x++;
                } else continue;
            }

            sb.append(rollDice(x, y, dir)).append("\n");
        }

        System.out.println(sb);

    }

    private static int rollDice(int x, int y, int dir) {

//        if (0 > x || x >= N || 0 > y || y >= M) {
//            return -1;
//        }

        int temp1 = dice[1];
        int temp2 = dice[2];
        int temp3 = dice[3];
        int temp4 = dice[4];
        int temp5 = dice[5];
        int temp6 = dice[6];

        switch (dir) {
            // 동쪽
            case 1: {
                dice[1] = temp4;
//                dice[2] = temp2;
                dice[3] = temp1;
                dice[4] = temp6;
//                dice[5] = temp5;
                dice[6] = temp3;
                break;
            }

            // 서쪽
            case 2: {
                dice[1] = temp3;
//                dice[2] = temp2;
                dice[3] = temp6;
                dice[4] = temp1;
//                dice[5] = temp5;
                dice[6] = temp4;
                break;
            }

            // 북쪽
            case 3: {
                dice[1] = temp5;
                dice[2] = temp1;
//                dice[3] = temp3;
//                dice[4] = temp4;
                dice[5] = temp6;
                dice[6] = temp2;
                break;
            }

            // 남쪽
            case 4: {
                dice[1] = temp2;
                dice[2] = temp6;
//                dice[3] = temp3;
//                dice[4] = temp4;
                dice[5] = temp1;
                dice[6] = temp5;
                break;
            }

        }

        if (map[x][y] == 0) {
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        return dice[1];
    }
}
