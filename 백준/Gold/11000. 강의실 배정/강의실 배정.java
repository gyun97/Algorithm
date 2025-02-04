import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] classes = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            classes[i][0] = start;
            classes[i][1] = end;
        }

        Arrays.sort(classes, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
//        System.out.println(Arrays.deepToString(classes));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] c : classes) {
            int endTime = c[1];
            int startTime = c[0];
            if (!pq.isEmpty() && pq.peek() <= startTime) {
                pq.poll();
            }
            pq.offer(endTime);
        }

        System.out.println(pq.size());

    }

}
