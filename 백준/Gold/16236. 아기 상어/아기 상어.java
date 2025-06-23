import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Fish implements Comparable<Fish> {
    int x;
    int y;
    int dist;

    public Fish(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public int compareTo(Fish o) {
        if (this.dist != o.dist) return this.dist - o.dist;
        if (this.x != o.x) return this.x - o.x;
        return this.y - o.y;
    }


}

public class Main {

    static int N, time, sharkSize, eatCount;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; // 가장 위에 있는 물고기 최우선
    static int[] dy = {0, -1, 1, 0}; // 가장 왼쪽에 있는 물고기 차선

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        time = 0;
        eatCount = 0;
        sharkSize = 2;

        int startX = 0, startY = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    startX = i;
                    startY = j;
                }
            }
        }

        while (true) {
            Fish target = bfsShark(startX, startY);
            if (target == null) break;

            time += target.dist;
            startX = target.x;
            startY = target.y;
            map[target.x][target.y] = 0;

            eatCount++;
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);

    }

    private static Fish bfsShark(int startX, int startY) {
        boolean[][] visited = new boolean[N][N];
        PriorityQueue<Fish> pq = new PriorityQueue<>();
        visited[startX][startY] = true;
        pq.offer(new Fish(startX, startY, 0));

        while (!pq.isEmpty()) {
            Fish cur = pq.poll();

            if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < sharkSize) {
                return cur;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!visited[nx][ny] && sharkSize >= map[nx][ny]) {
                        visited[nx][ny] = true;
                        pq.offer(new Fish(nx, ny, cur.dist + 1));

                    }
                }
            }

        }
        return null;

    }


}





