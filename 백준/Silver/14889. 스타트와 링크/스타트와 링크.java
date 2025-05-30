import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[][] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        min = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        teamMatching(0, 1);
        sb.append(min);
        System.out.println(sb);
    }

    private static int calculateScore() {

        int startScore = 0;
        int linkScore = 0;

        for (int i = 1; i < visited.length; i++) {
            for (int j = i + 1; j < visited.length; j++) {
                if (visited[i] && visited[j]) {
                    startScore += (A[i][j] + A[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    linkScore += (A[i][j] + A[j][i]);
                }
            }

        }
        return Math.abs(startScore - linkScore);
    }

    private static void teamMatching(int depth, int idx) {
        if (depth == N / 2) {
            int result = calculateScore();
            min = Math.min(min, result);
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                teamMatching(depth + 1, i + 1);
                visited[i] = false;
            }
        }

    }




}







