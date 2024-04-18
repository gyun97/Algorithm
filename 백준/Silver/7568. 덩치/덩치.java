import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] a = new int[N][2];

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            a[i][0] = w;
            a[i][1] = h;
        }

        for (int i = 0; i < N; i++) {
            int count = 0;
            int w1 = a[i][0];
            int h1 = a[i][1];
            for (int j = 0; j < N; j++) {
                int w2 = a[j][0];
                int h2 = a[j][1];
                if ((w1 < w2) && (h1 < h2)) {
                    count += 1;
                }

            }
            result[i] = count;
        }

//        Arrays.stream(result).forEach(i -> System.out.print(i + 1 + " "));
        Arrays.setAll(result, i -> result[i] + 1);
//        Arrays.stream(result).forEach(value -> value++);
        Arrays.stream(result).forEach(i -> sb.append(i + " "));
        System.out.println(sb);


    }
}