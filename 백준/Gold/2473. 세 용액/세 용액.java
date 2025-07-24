import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int val1 = 0, val2 = 0, val3 = 0;
        long minAbs = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = (long)solutions[i] + solutions[left] + solutions[right];

                if (Math.abs(sum) < minAbs) {
                    minAbs = Math.abs(sum);
                    val1 = solutions[i];
                    val2 = solutions[left];
                    val3 = solutions[right];
                }

                if (sum < 0) left++;
                else right--;
            }
        }

        int[] answer = {val1, val2, val3};
        Arrays.sort(answer);

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
