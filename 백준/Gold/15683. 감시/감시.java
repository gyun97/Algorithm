import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


class CCTV {
    int x;
    int y;
    int type;

    public CCTV(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static List<CCTV> cctvs = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0}; // 0번: 상, 1번: 하
    static int[] dy = {0, 0, -1, 1}; // 2번: 좌, 3번: 우
    static int minBlindSpot = Integer.MAX_VALUE;
    static int[][][] directions = {
            {}, // 0번 CCTV: 방향 없음
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 1}, {2, 3}}, // 2번 CCTV
            {{0, 3}, {0, 2}, {2, 1}, {1, 3}}, // 3번 CCTV
            {{0, 2, 3}, {2, 1, 3}, {0, 2, 1}, {0, 3, 1}}, // 4번 CCTV
            {{0, 2, 3, 1}} //5번 CCTV
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사무실 세로 크기
        M = Integer.parseInt(st.nextToken()); // 사무실 가로 크기

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) cctvs.add(new CCTV(i, j, map[i][j]));
            }
        }

        dfs(0, map);
        System.out.println(minBlindSpot);
    }

    private static void dfs(int depth, int[][] office) {
        if (depth == cctvs.size()) {
            minBlindSpot = Math.min(minBlindSpot, countBlindSpots(office));
            return;
        }

        CCTV cctv = cctvs.get(depth);
        int type = cctv.type;

        for (int[] dirs : directions[type]) {
            int[][] copyOffice = copyMap(office);
            watchCCTV(copyOffice, cctv.x, cctv.y, dirs);
            dfs(depth + 1, copyOffice);
        }
    }

    private static int[][] copyMap(int[][] office) {
        int[][] copyOffice = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyOffice[i] = office[i].clone();
        }

        return copyOffice;
    }

    private static void watchCCTV(int[][] office, int x, int y, int[] dirs) {
        for (int d : dirs) {
            int nx = x;
            int ny = y;

            while (true) {
                nx = nx + dx[d];
                ny = ny + dy[d];
                if (0 > nx || nx >= N || 0 > ny || ny >= M || office[nx][ny] == 6) break;

                if (office[nx][ny] == 0) office[nx][ny] = -1;

            }
        }
    }

    private static int countBlindSpots(int[][] office) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (office[i][j] == 0) count++;
            }
        }
        return count;
    }
}





