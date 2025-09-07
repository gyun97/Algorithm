import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(minDiff);
    }

    // idx: 현재 사람 번호, count: 현재 스타트팀에 넣은 사람 수
    static void dfs(int idx, int count) {
        // 스타트팀에 최소 1명 이상, 링크팀도 최소 1명 이상이면서 모든 인원을 다 봤을 때
        if (idx == N) {
            if (count > 0 && count < N) {
                calcDiff();
            }
            return;
        }

        // 현재 idx 사람을 스타트팀에 넣는 경우
        visited[idx] = true;
        dfs(idx + 1, count + 1);

        // 현재 idx 사람을 링크팀에 넣는 경우
        visited[idx] = false;
        dfs(idx + 1, count);
    }

    static void calcDiff() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) { // 둘 다 스타트팀
                    startSum += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) { // 둘 다 링크팀
                    linkSum += S[i][j] + S[j][i];
                }
            }
        }
        minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));
    }
}
