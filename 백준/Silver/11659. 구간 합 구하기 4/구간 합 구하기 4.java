import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.stream(arr).forEach(System.out::println);

            ArrayList<Integer> prefixSum = new ArrayList<>();
            prefixSum.add(0);
            int temp = 0;
            for (int i : arr) {
                temp += i;
                prefixSum.add(temp);
            }
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());



//        prefixSum.parallelStream().forEach(System.out::println);

            sb.append(prefixSum.get(b) - prefixSum.get(a - 1)).append("\n");
        }

        System.out.println(sb);
    }
}