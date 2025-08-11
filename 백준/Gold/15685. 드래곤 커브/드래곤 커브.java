import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[][] map = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};  // →(0), ←(2) (문제 정의와 맞춤)
    static int[] dy = {0, -1, 0, 1}; // ↑(1), ↓(3) (문제 정의와 맞춤)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawDragonCurve(x, y, d, g);
        }

        System.out.println(countSquares());

    }

    private static void drawDragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        for (int gen = 0; gen < g; gen++) {
            for (int i = directions.size() - 1; i >= 0; i--) {
                directions.add((directions.get(i) + 1) % 4);
            }
        }

        map[y][x] = true; // 시작점
        for (int dir : directions) {
            x += dx[dir];
            y += dy[dir];
            map[y][x] = true;
        }
    }

    private static int countSquares() {
        int count = 0;
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (map[y][x] && map[y][x + 1] && map[y + 1][x] && map[y + 1][x + 1]) count++;
            }
        }
        return count;
    }

}





