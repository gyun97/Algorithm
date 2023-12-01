import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        int[] cost = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for (int j = 0; j < N; j++) {
            cost[j] = Integer.parseInt(st.nextToken());
        }

        int min_cost = cost[0];
        long total_cost = 0;

        for (int i = 0; i < N - 1; i++) {
            if (cost[i] < min_cost) {
                min_cost = cost[i];
            }
            total_cost += (long) min_cost * dist[i];

        }

        sb.append(total_cost);
        System.out.println(sb);

    }
}





