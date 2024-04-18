import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());


        while (T --> 0) {
            int k = Integer.parseInt(br.readLine());  // 층
            int n = Integer.parseInt(br.readLine());  // 호

            int[] apart = new int[n];

            IntStream.range(1, n + 1).forEach(i -> apart[i - 1] = i);
//            Arrays.stream(apart).forEach(System.out::println);

            for (int x = 0; x < k; x++){
                for (int y = 1; y < n; y++) {
                    apart[y] += apart[y - 1];
                }
            }
            System.out.println(apart[n - 1]);

        }
    }
}