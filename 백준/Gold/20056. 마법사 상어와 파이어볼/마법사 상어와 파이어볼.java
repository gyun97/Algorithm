import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class FireBall{
    int r; // 행
    int c; // 열
    int m; // 질량
    int s; // 속력
    int d; // 방향

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}

public class Main {
    static int N, M, K, answer;
    static Queue<FireBall>[][] board;
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행, 열
        M = Integer.parseInt(st.nextToken()); // 파이어볼의 개수
        K = Integer.parseInt(st.nextToken()); // 이동 명령 횟수

        board = new Queue[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = new ArrayDeque<>();
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 행
            int c = Integer.parseInt(st.nextToken()); // 열
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 방향

            board[r][c].add(new FireBall(r, c, m, s, d));
        }

        while (K-- > 0) {
            // 1. 모든 파이어볼이 자신의 방향 di로 속력 si칸 만큼 이동한다.
            // - 이동하는 중에는 같은 칸에 여러 개의 파이어볼이 있을 수도 있다.
            moving();
            addFireBall();
        }


        calculateS();
        System.out.println(answer);
    }

    private static void calculateS() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!board[i][j].isEmpty()) {
                    Queue<FireBall> q = board[i][j];
                    while (!q.isEmpty()) {
                        FireBall cur = q.poll();
                        answer += cur.m;
                    }
                }
            }
        }
    }

    private static void addFireBall() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (board[r][c].size() >= 2) {
                    Queue<FireBall> q = board[r][c];
                    List<Integer> even = new ArrayList<>();
                    List<Integer> odd = new ArrayList<>();
                    int sumM = 0, sumS = 0;
                    int size = q.size();

                    while (!q.isEmpty()) {
                        FireBall cur = q.poll();
                        sumM += cur.m;
                        sumS += cur.s;
                        if (cur.d % 2 == 0) {
                            even.add(cur.s);
                        } else {
                            odd.add(cur.s);
                        }
                    }

                    if (sumM / 5 == 0) continue; // 질량이 0인 파이어볼은 소멸되어 없어진다.

                    // 합쳐지는 파이어볼의 방향이 모두 짝수 혹은 홀수였던 경우
                    if (even.size() == 0 || odd.size() == 0) {
                        int d = -2;
                        for (int i = 0; i < 4; i++) {
                            d += 2;
                            q.add(new FireBall(r, c, sumM / 5, sumS / size, d));
                        }
                    } else {
                        // 방향이 모두 짝수이거나 홀수이지 않은 경우
                        int d = -1;
                        for (int i = 0; i < 4; i++) {
                            d += 2;
                            q.add(new FireBall(r, c, sumM / 5, sumS / size, d));
                        }
                    }
                }
            }
        }

    }

    private static void moving() {

        Queue<FireBall>[][] temp = new Queue[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                temp[i][j] = new ArrayDeque<>();
            }
        }

        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                if (!board[r][c].isEmpty()) {
                    Queue<FireBall> q = board[r][c];
                    while (!q.isEmpty()) {
                        FireBall cur = q.poll();

                        int curD = cur.d;
                        int nr = (r + dr[curD] * cur.s) % N;
                        int nc = (c + dc[curD] * cur.s) % N;
                        if (nr <= 0) nr += N;
                        if (nc <= 0) nc += N;
                        temp[nr][nc].add(new FireBall(nr, nc, cur.m, cur.s, cur.d));
                    }
                }
            }
        }
        board = temp;
    }


}


