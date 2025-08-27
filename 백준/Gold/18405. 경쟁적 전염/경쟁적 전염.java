import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Virus implements Comparable<Virus> {
    int num;
    int x;
    int y;
    int time;

    public Virus(int num, int x, int y, int time) {
        this.num = num;
        this.x = x;
        this.y = y;
        this.time = time;
    }

    @Override
    public int compareTo(Virus o) {
        if (time == o.time) {
            return num - o.num;
        }
        return time - o.time;
    }
}

public class Main {
    static int N, K, S, X, Y;
    static int[][] tube;
    static PriorityQueue<Virus> pq;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 시험관의 행과 열
        K = Integer.parseInt(st.nextToken()); // 바이러스의 종류
        tube = new int[N + 1][N + 1]; // 시험관
        pq = new PriorityQueue<>();


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                tube[i][j] = Integer.parseInt(st.nextToken());
                if (tube[i][j] != 0) pq.add(new Virus(tube[i][j], i, j, 1));

            }
        }

        // S초 뒤에 (X, Y)에 존재하는 바이러스의 종류 출력
        // 만약 S초 뒤에 해당 위치에 바이러스가 존재하지 않는다면, 0을 출력한다.
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        int time = 0;
        spread(S);

        System.out.println(tube[X][Y]);
    }

    private static void spread(int timeLimit) {
        while (!pq.isEmpty()) {
            Virus virus = pq.poll();

            if (virus.time > timeLimit) return;

            for (int d = 0; d < 4; d++) {
                int nx = virus.x + dx[d];
                int ny = virus.y + dy[d];
                if (0 >= nx || nx > N || 0 >= ny || ny > N || tube[nx][ny] != 0) continue;
                pq.add(new Virus(virus.num, nx, ny, virus.time + 1));
                tube[nx][ny] = virus.num;
            }
        }


    }


}


