import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int N, max;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        max = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        dfs(0, board);
        System.out.println(max);

    }

    private static void dfs(int depth, int[][] map) {
        if (depth == 5) return;

        for (int dir = 0; dir < 4; dir++) {
            int[][] moved = move(dir, map);
            dfs(depth + 1, moved);
        }

    }

    private static int[][] move(int dir, int[][] map) {
        int[][] newMap = new int[N][N];

        // deep copy: 2차원 배열의 경우 deep copy하려면 2중 for문을 쓰거나 clone 반복문을 사용해야 함.
        for (int i = 0; i < N; i++) {
            newMap[i] = map[i].clone();
        }

        boolean[][] merged = new boolean[N][N]; // 이번 턴에 해당 블록이 합쳐져서 더는 못 합쳐지는지 체크하는 배열

        // 블록들을 위로 이동시키는 경우
        if (dir == 0) {
            for (int col = 0; col < N; col++) { // 위로 블록을 옮기는 것은 각 열마다 이루어지기 때문에 col이 선행 for문
                for (int row = 1; row < N; row++) { // 0행은 가장 위이기 때문에 위로 이동이 불가능하여 행은 1행부터 시작
                    if (newMap[row][col] == 0) continue; // 해당 칸이 공백이면 다음으로 넘어가기

                    int cur = row;

                    // 해당 열의 블록들 가장 위까지 옮기기
                    while (cur > 0 && newMap[cur - 1][col] == 0) { // 가장 윗행이 아니고 한 칸 위에 블록이 없을 시에
                        newMap[cur - 1][col] = newMap[cur][col]; // 블록 한칸 위로 땡기기
                        newMap[cur][col] = 0; // 기존 블록 위치는 빈 칸으로 처리
                        cur--;
                    }

                    if (cur > 0 && newMap[cur - 1][col] == newMap[cur][col] && !merged[cur - 1][col] && !merged[cur][col]) { // 위아래의 두 블록의 값이 같고 아직 둘 다 merge되지 않은 상태라면
                        newMap[cur - 1][col] *= 2; // 두 개 합쳐서 값 2배의 새로운 블록 탄생
                        newMap[cur][col] = 0;
                        merged[cur - 1][col] = true;
                        max = Math.max(max, newMap[cur - 1][col]);
                    }
                }
            }
        }
        // 블록들을 아래로 이동시키는 경우
        else if (dir == 1) {
            for (int col = 0; col < N; col++) { // 아래로 블록을 옮기는 것은 각 열마다 이루어지기 때문에 col이 선행 for문
                for (int row = N - 2; row >= 0; row--) { // N - 1 행은 가장 아래여서 아래로 이동이 불가능하기 때문에 행은 N - 2부터 시작
                    if (newMap[row][col] == 0) continue; // 해당 칸이 공백이면 다음으로 넘어가기

                    int cur = row;

                    // 해당 열의 블록들 가장 밑까지 옮기기
                    while (cur < N - 1 && newMap[cur + 1][col] == 0) {
                        newMap[cur + 1][col] = newMap[cur][col];
                        newMap[cur][col] = 0;
                        cur++;
                    }

                    if (cur < N - 1 && newMap[cur + 1][col] == newMap[cur][col] && !merged[cur + 1][col] && !merged[cur][col]) {
                        newMap[cur + 1][col] *= 2;
                        newMap[cur][col] = 0;
                        merged[cur + 1][col] = true;
                        max = Math.max(max, newMap[cur + 1][col]);
                    }

                }
            }
        }
        // 블록들을 좌로 이동시키는 경우
        else if (dir == 2) {
            for (int row = 0; row < N; row++) {
                for (int col = 1; col < N; col++) {
                    if (newMap[row][col] == 0) continue;

                    int cur = col;

                    while (cur > 0 && newMap[row][cur - 1] == 0) {
                        newMap[row][cur - 1] = newMap[row][cur];
                        newMap[row][cur] = 0;
                        cur--;
                    }

                    if (cur > 0 && newMap[row][cur - 1] == newMap[row][cur] && !merged[row][cur - 1] && !merged[row][cur]) {
                        newMap[row][cur - 1] *= 2;
                        newMap[row][cur] = 0;
                        merged[row][cur - 1] = true;
                        max = Math.max(max, newMap[row][cur - 1]);
                    }

                }
            }
        }
        // 블록들을 우로 이동시키는 경우
        else if (dir == 3) {
            for (int row = 0; row < N; row++) {
                for (int col = N - 2; col >= 0; col--) {
                    if (newMap[row][col] == 0) continue;

                    int cur = col;

                    while (cur < N - 1 && newMap[row][cur + 1] == 0) {
                        newMap[row][cur + 1] = newMap[row][cur];
                        newMap[row][cur] = 0;
                        cur++;
                    }

                    if (cur < N - 1 && newMap[row][cur] == newMap[row][cur + 1] && !merged[row][cur] && !merged[row][cur + 1]) {
                        newMap[row][cur + 1] *= 2;
                        newMap[row][cur] = 0;
                        merged[row][cur + 1] = true;
                        max = Math.max(max, newMap[row][cur + 1]);
                    }
                }
            }
        }

        return newMap;
    }


}





