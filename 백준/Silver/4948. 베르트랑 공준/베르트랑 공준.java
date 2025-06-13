import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            sb.append(eratos(N)).append("\n");
        }

        System.out.println(sb);

    }

    private static int eratos(int n) {
        int count = 0;

        int[] A = new int[2 * n + 1];
        for (int i = 2; i <= 2 * n; i++) {
            A[i] = i;
//            System.out.println(A[i]);
        }

        for (int i = 2; i <= 2 * n; i++) {
            if (A[i] == 0) continue;
            for (int j = i * 2; j <= 2 * n; j += i) {
                A[j] = 0;
            }
        }
//
        for (int i = n + 1; i <= 2 * n; i++) {
            if (A[i] != 0) {
//                System.out.println(A[i]);
                count++;
            }
        }

        return count;


    }
}




