import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArray();

        printMap();
    }

    static void rotateArray() {
        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> values = new ArrayList<>();

            int r1 = layer, r2 = N - 1 - layer;
            int c1 = layer, c2 = M - 1 - layer;

            // 테두리 값 추출
            // 상
            for (int i = c1; i < c2; i++) values.add(map[r1][i]);
            // 우
            for (int i = r1; i < r2; i++) values.add(map[i][c2]);
            // 하
            for (int i = c2; i > c1; i--) values.add(map[r2][i]);
            // 좌
            for (int i = r2; i > r1; i--) values.add(map[i][c1]);

            int perimeter = values.size();
            int rot = R % perimeter;

            // 회전된 리스트 만들기
            List<Integer> rotated = new ArrayList<>();
            for (int i = 0; i < perimeter; i++) {
                rotated.add(values.get((i + rot) % perimeter));
            }

            int idx = 0;

            // 다시 넣기 (같은 순서로)
            // 상
            for (int i = c1; i < c2; i++) map[r1][i] = rotated.get(idx++);
            // 우
            for (int i = r1; i < r2; i++) map[i][c2] = rotated.get(idx++);
            // 하
            for (int i = c2; i > c1; i--) map[r2][i] = rotated.get(idx++);
            // 좌
            for (int i = r2; i > r1; i--) map[i][c1] = rotated.get(idx++);
        }
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : map) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
