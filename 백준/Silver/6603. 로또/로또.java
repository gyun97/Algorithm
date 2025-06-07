import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int k;
    static int[] A, result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            A = new int[k];
            result = new int[6];

            for (int i = 0; i < k; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0, 0);
            sb.append("\n");

        }

        System.out.println(sb);
    }

    private static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < A.length; i++) {
            result[depth] = A[i];
            backtracking(depth + 1, i + 1);
        }




    }


}


