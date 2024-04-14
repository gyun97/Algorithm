import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] lans = new int[N];

        for (int i = 0; i < N; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        sb.append(binary_search(lans, K));
        System.out.println(sb);

    }

    private static long binary_search(int[] lans, int K) {
        long start = 1;
        long end = Arrays.stream(lans).max().getAsInt();

        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;
            for (int lan : lans) {
                count += lan / mid;
            }
            if (count >= K) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return  end;
    }


}
