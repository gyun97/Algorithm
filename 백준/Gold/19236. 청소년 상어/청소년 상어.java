import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Fish {
    int x;
    int y;
    int dir;
    boolean alive;

    public Fish(int x, int y, int dir, boolean alive) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.alive = alive;
    }

    public Fish(Fish f) {
        this.x = f.x;
        this.y = f.y;
        this.dir = f.dir;
        this.alive = f.alive;
    }

}


public class Main {
    static int answer;
    static int[][] board;
    static Fish[] fish;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[4][4];
        fish = new Fish[17];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                board[i][j] = a;
                fish[a] = new Fish(i, j, b,true);
            }
        }

        // 상어 시작(0, 0)에 있는 물고기 먹음
        int firstFish = board[0][0];
        int sharkDir = fish[firstFish].dir;
        fish[firstFish].alive = false;
        board[0][0] = -1; // 상어 위치
        dfs(board, fish, 0, 0, sharkDir, firstFish);

        System.out.println(answer);

    }

    private static void dfs(int[][] curBoard, Fish[] curFish, int sx, int sy, int sharkDir, int sum) {
        answer = Math.max(answer, sum);
        fishMove(curBoard, curFish);

        // 상어가 움직일 수 있는 칸은 1 ~ 3 칸
        for (int step = 1; step <= 3; step++) {
            int nx = sx + dx[sharkDir] * step;
            int ny = sy + dy[sharkDir] * step;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4) {
                break; // 범위 벗어나면 진행 불가
            }

            if (curBoard[nx][ny] <= 0) { // 빈칸일시 이동불가
                continue;
            }

            // 상태 복사
            int[][] newBoard = new int[4][4];
            for (int i = 0; i < 4; i++) {
                newBoard[i] = curBoard[i].clone();
            }

            Fish[] newFish = new Fish[17];
            for (int i = 1; i <= 16; i++) {
                if (curFish[i] != null)
                    newFish[i] = new Fish(curFish[i]);
            }

            // 상어가 물고기 먹음
            int eatFish = newBoard[nx][ny];
            int ndir = newFish[eatFish].dir;
            newFish[eatFish].alive = false;

            newBoard[nx][ny] = -1;
            newBoard[sx][sy] = 0;

            dfs(newBoard, newFish, nx, ny, ndir, sum + eatFish);
        }
    }

    private static void fishMove(int[][] curBoard, Fish[] curFish) {
        for (int i = 1; i <= 16; i++) {
            if (curFish[i] == null || !curFish[i].alive) continue;

            int x = curFish[i].x;
            int y = curFish[i].y;
            int dir = curFish[i].dir;

            for (int r = 0; r < 8; r++) {
                int ndir = (r + dir) % 8; // 이동할수 없을 시 반시계 방향으로 45도 회전
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];

                // 범위 밖을 벗어나거나 상어가 있는 칸의 경우 이동 불가
                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4 || curBoard[nx][ny] == -1) continue;

                // 만약 해당 칸에 물고기가 없다면
                if (curBoard[nx][ny] == 0) {
                    // 좌표 갱신
                    curBoard[nx][ny] = i;
                    curBoard[x][y] = 0;
                    curFish[i].x = nx;
                    curFish[i].y = ny;
                } else { // 만약 해당 칸에 물고기가 있다면
                    // 물고기간 위치 트레이드

                    // 해당 칸에 이미 존재하던 물고기 기존 칸으로 옮기기
                    int existFish = curBoard[nx][ny];
                    curBoard[x][y] = existFish;
                    curFish[existFish].x = x;
                    curFish[existFish].y = y;

                    // 현재 물고기 새로운 칸으로 옮기기
                    curBoard[nx][ny] = i;
                    curFish[i].x = nx;
                    curFish[i].y = ny;
                }

                curFish[i].dir = ndir;
                break;
            }

        }
    }
}


