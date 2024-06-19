import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;




class Point3D {
    int z, x, y, count;

    public Point3D(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;

    }

}


class Main {

    static int N, M, H;
    static int[][][] tomatoes;
    static Queue<Point3D> queue = new LinkedList<>();
    static int day = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 수
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 수
        H = Integer.parseInt(st.nextToken()); // 쌓아올려진 상자 수

        tomatoes = new int[H][N][M];


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoes[i][j][k] == 1) {
                        queue.add(new Point3D(i, j, k));
                    }
                }
            }
        }
        bfs();

        checkingResult();

        sb.append(day - 1);
        System.out.println(sb);

    }

    private static void checkingResult() {

            LOOP:
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (tomatoes[i][j][k] == 0) {
                            sb.append(-1);
                            System.out.println(sb);
                            System.exit(0);
                        } else {
                            day = Math.max(tomatoes[i][j][k], day);
                        }
                    }
                }
            }

        }


    private static void bfs() {
        while (!queue.isEmpty()) {
            Point3D currentPoint = queue.poll();
            int[] dz = {0, 0, 0, 0, 1, -1};
            int[] dx = {1, -1, 0, 0, 0, 0};
            int[] dy = {0, 0, 1, -1, 0, 0};

            for (int i = 0; i < 6; i++) {
                int nz = currentPoint.z + dz[i];
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];

                if (0 > nz || nz >= H) continue;
                if (0 > nx || nx >= N) continue;
                if (0 > ny || ny >= M) continue;
                if (tomatoes[nz][nx][ny] == 0) {
                    queue.add(new Point3D(nz, nx, ny));
                    tomatoes[nz][nx][ny] = tomatoes[currentPoint.z][currentPoint.x][currentPoint.y] + 1;
                }

            }

        }


    }


    }


