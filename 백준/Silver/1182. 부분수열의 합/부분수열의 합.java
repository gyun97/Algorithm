import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, S, count;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        dfs(0, 0);

        // 공집합 제외
        if (S == 0) count--;
        
        System.out.println(count);
    }

    private static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 포함하는 경우
        dfs(idx + 1, sum + A[idx]);

        // 현재 원소를 포함하지 않는 경우
        dfs(idx + 1, sum);
    }
}
