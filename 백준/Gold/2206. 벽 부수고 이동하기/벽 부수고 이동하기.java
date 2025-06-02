import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;
    int dist;
    boolean broken;

    public Node(int x, int y, int dist, boolean broken) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.broken = broken;
    }
}

public class Main {

    static int N, M, min;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];

        int result = bfs(0, 0, 1, false);
//        System.out.println(Arrays.deepToString(visited));
        sb.append(result);
        System.out.println(sb);

    }

    private static int bfs(int x, int y, int dist, boolean broken) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y, dist, broken));
        visited[x][y][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 > nx || nx >= N || 0 > ny || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 0) { // 벽 X
                    if (!cur.broken && !visited[nx][ny][0]) { // 아직 벽 안 부신 경우
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, cur.dist + 1, false));
                    } else if (cur.broken && !visited[nx][ny][1]) { // 이미 벽 부신 경우
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, cur.dist + 1, true));
                    }
                } else if (map[nx][ny] == 1) { // 벽 O
                    if (!cur.broken) { // 아직 벽 안 부신 경우
                        // 벽 부신다
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, cur.dist + 1, true));
                    }

                    // 이미 벽 부셨다면 벽 못 지나가기 때문에 코드 생략
                }

            }
        }
        return -1;
    }


}
