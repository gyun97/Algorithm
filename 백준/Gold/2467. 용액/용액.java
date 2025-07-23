import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] solutions = new int[N];
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int start = 0;
        int end = N - 1;
        int result = Integer.MAX_VALUE;
        int answer1 = 0, answer2 = 0;

        while (start < end) {
            int newResult = solutions[start] + solutions[end];
            if (Math.abs(newResult) < result) {
                result = Math.abs(newResult);
                answer1 = solutions[start];
                answer2 = solutions[end];
            }

            if (newResult < 0) {
                start++;
            } else {
                end--;
            }


        }

        System.out.println(answer1 + " " + answer2);


    }
}

