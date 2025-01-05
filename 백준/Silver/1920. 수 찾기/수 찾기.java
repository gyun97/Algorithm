import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        Loop:
        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int first = 0;
            int last = A.length - 1;

            while (first <= last) {
                int mid = (first + last) / 2;
                if (target > A[mid]) {
                    first = mid + 1;
                } else if (target < A[mid]) {
                    last = mid - 1;
                } else {
                    sb.append(1).append("\n");
                    continue Loop;
                }
            }

            sb.append(0).append("\n");

        }

        System.out.println(sb);

    }

}


