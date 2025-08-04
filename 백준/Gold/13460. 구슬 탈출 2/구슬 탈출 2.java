import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State {
    int rx;
    int ry;
    int bx;
    int by;
    int depth;

    public State(int rx, int ry, int bx, int by, int depth) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.depth = depth;
    }
}

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited; // 빨간 구슬의 (x, y) 방문 기록과 파란 구슬의 (x, y) 방문 기록 동시 기록   ex) 빨간 구슬 (1,2)이고 파란 구슬 (3,4)일 때 방문 기록 저장
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        // rx = 빨간 구슬의 현재 행 위치, ry = 빨간 구슬의 현재 열 위치, bx = 파란 구슬의 현재 행 위치, by = 파란 구슬의 현재 열 위치
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        visited = new boolean[N][M][N][M];

        System.out.println(bfs(rx, ry, bx, by));

    }

    private static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> q = new LinkedList<>();
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] red = move(cur.rx, cur.ry, dx[d], dy[d]); // 기울여서 빨간 구슬이 이동한 위치의 (x, y) 좌표와 이동 횟수, dx = 위 또는 아래
                int[] blue = move(cur.bx, cur.by, dx[d], dy[d]); // 기울여서 파란 구슬이 이동한 위치의 (x, y) 좌표와 이동 횟수, dy = 좌 또는 우

                int nrx = red[0], nry = red[1], rMove = red[2];
                int nbx = blue[0], nby = blue[1], bMove = blue[2];

                if (board[nbx][nby] == 'O') continue; // 만약 파란 구슬이 구멍으로 빠지면 실패이기 때문에 다시하기
                if (board[nrx][nry] == 'O') { // 만약 빨간 구슬이 구멍으로 빠지면 이전의 횟수 + 1한 후 종료하기
                    return cur.depth + 1;
                }

                if (nrx == nbx && nry == nby) { // 만약 빨간 구슬과 파란 구슬의 위치(좌표)가 똑같다
                    if (rMove > bMove) { // 빨간 구슬이 더 많이 이동했다면 더 뒤에 있었다는 뜻이기 때문에 직전의 위치로 한 칸 후퇴
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else { // 파란 구슬이 더 많이 이동했다면 더 뒤에 있었다는 뜻이기 때문에 직전의 위치로 한 칸 후퇴
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) { // 아직 방문하지 않은 상태라면 큐에 추가
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }


            }
        }

        return -1;

    }

    private static int[] move(int x, int y, int dx, int dy) {
        int count = 0;

        while (board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            count++;
            x += dx;
            y += dy;

            if (board[x][y] == 'O') break;
        }

        return new int[]{x, y, count};
    }


}





