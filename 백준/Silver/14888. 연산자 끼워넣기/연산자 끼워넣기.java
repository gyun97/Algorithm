import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, max, min;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        B = new int[4];
        for (int i = 0; i < 4; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        calculate(0, A[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);

    }

    private static void calculate(int count, int result) {

        if (count == N - 1) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (B[i] > 0) {
                B[i]--;
                int next = 0;
                switch(i) {
                    case 0:
                        next = result + A[count + 1];
                        break;
                    case 1:
                        next = result - A[count + 1];
                        break;
                    case 2:
                        next = result * A[count + 1];
                        break;
                    case 3:
                        if (result < 0) {
                            next = -(-result / A[count + 1]);
                        } else {
                            next = result / A[count + 1];
                        }
                        break;
                }
                calculate(count + 1, next);
                B[i]++;
            }

        }

    }


}





