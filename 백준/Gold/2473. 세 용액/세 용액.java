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
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int val1 = 0, val2 = 0, val3 = 0;
        long result = Long.MAX_VALUE;

        for (int cur = 0; cur < N - 2; cur++) {
            int start = cur + 1;
            int end = N - 1;
            while (start < end) {
                long newResult = (long)solutions[cur] + solutions[start] + solutions[end];
                if (result > Math.abs(newResult)) {
                    result = Math.abs(newResult);
                    val1 = solutions[cur];
                    val2 = solutions[start];
                    val3 = solutions[end];
                }

                if (newResult < 0) {
                    start++;
                } else {
                    end--;
                }

            }

        }

        int[] results = new int[3];
        results[0] = val1;
        results[1] = val2;
        results[2] = val3;
        Arrays.sort(results);

        System.out.println(results[0] + " " + results[1] + " " + results[2]);
    }


}

