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
        int M = Integer.parseInt(br.readLine());
        int[] array = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

//        System.out.println(Arrays.toString(array));
        Arrays.sort(array);

        int left = 1;
        int right = N;
        int answerCount = 0;

        while (right != left) {
            int sum = array[left] + array[right];
            if (sum < M) {
                left++;
            } else if (sum > M) {
                right--;
            } else if (sum == M) {
                answerCount++;
                left++;
            }
        }
        sb.append(answerCount);
        System.out.println(sb);
    }
}
