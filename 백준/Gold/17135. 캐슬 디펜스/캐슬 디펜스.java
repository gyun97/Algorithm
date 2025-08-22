import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {
    static int N, M, D, count;
    static int[][] board;

    // 왼쪽에 있는 적을 우선 공격해야 하기 때문에 왼쪽 -> 위 -> 오른쪽 순으로 탐색(궁수는 가장 밑에 존재하기 때문에 궁수보다 아래에 적이 없어서 아래는 탐색 X)
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 사거리
        count = 0;

        board = new int[N + 1][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 궁수가 사정거리 D 내의 가장 가까운, 거리가 가까우면 가장 왼쪽의 적을 죽이면 적은 게임에서 제외된다.
        // 적이 아래로 한 칸씩 이동하고 성이 있는 위치에 도달하면 게임에서 제외된다,
        // 모든 적이 게임에서 제외되면 게임은 끝난다.

        int answer = 0;

        // 궁수 3명 배치 브루트 포스
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                for (int k = j + 1; k < M; k++) {


                    int[][] temp = new int[N + 1][M];
                    for (int l = 0; l < N + 1; l++) {
                        temp[l] = board[l].clone();
                    }

//                    temp[N][i] = 2; // 궁수 배치1
//                    temp[N][j] = 2; // 궁수 배치2
//                    temp[N][k] = 2; // 궁수 배치3

                    int attackCount = 0;

                    while (true) {
                        attackCount += ArcherAttack(temp, i, j, k); // i : 궁수1 위치, j: 궁수2 위치, k: 궁수3 위치
                        enemyMoving(temp);
                        if (isGameOver(temp)) {
                            break;
                        }
                    }

                    answer = Math.max(answer, attackCount);

                }
            }
        }

        System.out.println(answer);
    }


    private static boolean isGameOver(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) return false;
            }
        }
        return true;
    }


    private static void enemyMoving(int[][] board) {
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {

                // 적 한 칸 아래로 내리기
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    if (i == N - 1) continue;
                    board[i + 1][j] = 1;
                }
            }
        }
    }

    private static int ArcherAttack(int[][] board, int i, int j, int k) {
        Set<Point> attackTargets = new HashSet<>();
        int[] arachers = new int[]{i, j, k};
        int count = 0;

        for (int a = 0; a < 3; a++) {
            Point target = bfs(board, arachers[a]);
            if (target != null) attackTargets.add(target);
        }

        count = attackTargets.size();

        for (Point target : attackTargets) {
            board[target.x][target.y] = 0;
        }

        return count;
    }

    private static Point bfs(int[][] board, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M];
        q.add(new int[]{N, y, 0});
        visited[N][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int curCount = cur[2];

            for (int d = 0; d < 3; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) { // 격자 범위 안
                    if (curCount + 1 <= D && !visited[nx][ny]) { // 최단 거리가 궁수의 사정거리 D 이내이고 아직 방문하지 않은 칸이라면
                        q.add(new int[]{nx, ny, curCount + 1}); // 큐에 추가
                        if (board[nx][ny] == 1) return new Point(nx, ny); // 만약 적이 있는 칸이라면 가장 가까운 칸이기 때문에 바로 좌표 반환
                    }
                }
            }
        }
        return null;
    }
}
