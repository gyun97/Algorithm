import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] T, P, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 산술평균
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i];
        }

        int avg = (int) Math.round(sum / N);
//        System.out.println(avg);
        bw.write(avg + "\n");

        // 중앙값
        Arrays.sort(A);
        int median = A[N / 2];
//        System.out.println(median);
        bw.write(median + "\n");


        // 최빈값
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int max = 0;
        for (int i : map.values()) {
            if (max < i) {
                max = i;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        if (list.size() > 1) {
//            System.out.println(list.get(1));
            bw.write(list.get(1) + "\n");
        } else {
//            System.out.println(list.get(0));
            bw.write(list.get(0) + "\n");
        }

        // 범위
        Arrays.sort(A);
        int range = A[N - 1] - A[0];
        bw.write(range + "\n");

        bw.close();


    }
}
