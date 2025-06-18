import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        for (int i = 0; i < N; i++) {
            dp1[i] = 1; // 자기 자신 하나는 무조건 포함
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            dp2[i] = 1; // 자기 자신 하나는 무조건 포함
            for (int j = N - 1; j > i; j--) {
                if (A[j] < A[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        
        int result = -1;
        for (int i = 0; i < N; i++) {
            result = Math.max(result, dp1[i] + dp2[i] - 1);
        }

        System.out.println(result);
//        System.out.println(Arrays.toString(dp1));
//        System.out.println(Arrays.toString(dp2));




    }

}




