import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0, sum = 0;

        int minLen = Integer.MAX_VALUE;

        while (end != N) {
            sum += A[end];
            end++;
            while (sum >= S) {
                minLen = Math.min(minLen, end - start);
                sum -= A[start];
                start++;
            }
        }

//        System.out.println(Arrays.toString(sum));
        if (minLen == Integer.MAX_VALUE) minLen = 0;
        System.out.println(minLen);

    }
}
