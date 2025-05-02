import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[M];
//        for (int i = 0; i < N; i++) {
//            backtrace(0, i);
//        }
        backtrace(0, 1);
    }

    private static void backtrace(int depth, int start) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
            return;
        }

//        for (int i = 1; i <= N; i++) {
//            if (i > start) {
//                A[depth] = i;
//                backtrace(depth + 1, i);
//            }

        for (int i = start; i <= N; i++) {
            A[depth] = i;
            backtrace(depth + 1, i + 1);  // 다음 숫자는 i보다 커야 오름차순
        }

    }
}
