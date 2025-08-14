import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, H, answer;
    static boolean[][] ladder;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로선의 개수
        M = Integer.parseInt(st.nextToken()); // 가로선의 개수
        H = Integer.parseInt(st.nextToken()); // 세로선마다 가로선을 놓을 수 있는 위치의 개수
        ladder = new boolean[H + 1][N + 1];

        // 가로선들의 정보
        for (int i = 0; i < M; i++) {
            // b번 세로선과 b + 1 세로선을 a번 점선 위치에 연결
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }

        answer = 4;

        dfs(0, 1, 1);

        // i번 세로선의 결과가 i번이 나오도록 사다리 게임을 조작하려면, 추가해야 하는 가로선 개수의 최솟값을 출력한다.
        // 만약, 정답이 3보다 큰 값이면 -1을 출력한다. 또, 불가능한 경우에도 -1을 출력한다.

        System.out.println(answer > 3 ? -1 : answer);
    }

    private static void dfs(int count, int x, int y) {
        if (answer <= count) return; // 현재 추가해야 하는 가로선의 값이까지 기존 최솟값보다 크면 다시 이전으로 돌아가기
        if (check()) { // 만약 사다리 타기 선 긋기 조건을 충족한다면
            answer = count; // 최솟값 갱신
            return;
        }
        if (count == 3) return; // 그을 수 있는 가로선 개수 3개 이상 불가

        for (int i = x; i <= H; i++) {
            for (int j = (i == x ? y : 1); j < N; j++) {

                // 이미 가로선 있거나 양 옆에 인접한 곳에 가로선 있으면 불가능
                if (ladder[i][j] || ladder[i][j - 1] || ladder[i][j + 1]) continue;

                ladder[i][j] = true;
                dfs(count + 1, i, j);
                ladder[i][j] = false;

            }
        }

    }

    // i번 가로선이 i번으로 가는지 체크하는 메서드
    private static boolean check() {
        for (int start = 1; start <= N; start++) {
            int pos = start;
            for (int row = 1; row <= H; row++) {
                if (ladder[row][pos]) pos++;
                else if (pos > 1 && ladder[row][pos - 1]) pos--;
            }
            if (start != pos) return false;

        }
        return true;
    }
}
