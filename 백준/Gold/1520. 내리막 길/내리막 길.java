import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0}; // 지도 상, 하로 한 칸씩 이동
    static int[] dy = {0, 0, -1, 1}; // 지도 좌, 우로 한 칸씩 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기

        arr = new int[N][M]; // 지도
        dp = new int[N][M]; // 목표 지점(N - 1, M - 1)을 가는 데에 지도의 각 칸마다의 경로 개수
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // 아직 방문하지 않은 것을 뜻하는 -1로 초기화
            }
        }

        sb.append(dfs(0, 0)); // dfs로 시작 지점 (0, 0)에서 목표 지점 (N - 1, M -1)까지 각 칸마다 갈 수 있는 경로의 수의 dp 배열에 저장하면서 탐색
        System.out.println(sb);

    }

    private static int dfs(int x, int y) {

        // 만약 목표 지점 (N - 1, M - 1)까지 도달했다면
        if (x == N - 1 && y == M - 1) {
            return 1; /* 바로 직전의 해당 칸의 경로의 개수는 무조건 1이다 */
        }

        // 만약 이미 방문하여 경로의 개수가 갱신되어 -1이 아니라면
        if (dp[x][y] != -1) {
            return dp[x][y]; // 해당 칸의 기존 경로의 개수 바로 반환
        }

        dp[x][y] = 0; // 아직 방문 전이고 목표 지점 도달도 안 했다면 해당 칸 경로의 개수 0으로 갱신

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 상, 하로 각각 한 칸 이동
            int ny = y + dy[i]; // 좌, 우로 각각 한 칸 이동
            if (0 > nx || nx >= N || 0 > ny || ny >= M) { // 만약 지도의 범위를 벗어난다면
                continue; // 바로 다음 이동 살펴보기
            }
            if (arr[x][y] > arr[nx][ny]) { // 값이 더 낮은 지점으로 이동한다는 조건을 만족하면 이동
                dp[x][y] += dfs(nx, ny); // (nx, ny)에서 (N-1, M-1)까지 가는 모든 경로의 개수를 dp[x][y]에 더하기
            }

        }
        return dp[x][y];

    }
}

