import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static StringBuilder sb;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[M];

        backtracking(0, 1);
    }

    public static void backtracking(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (i >= start) {
                A[depth] = i;
                backtracking(depth + 1, i);
            }
        }
        
    }
}
