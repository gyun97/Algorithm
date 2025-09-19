import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X, answerCount;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        System.out.println(answerCount);
    }

    private static void dfs(int idx, int sum, int min, int max, int count) {
        if (idx == N) {
            if ((L <= sum && sum <= R) && (max - min >= X) && (count >= 2)) {
                answerCount++;
            }
            return;
        }
        
        // 1) 현재 문제 선택
        dfs(idx + 1, sum + A[idx], Math.min(min, A[idx]), Math.max(max, A[idx]), count + 1);

        // 2) 현재 문제 선택 안 함
        dfs(idx + 1, sum, min, max, count);
    }

}
