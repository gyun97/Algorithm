import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        sb.append("<");

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            count += 1;
            int first = queue.poll();

            if (count % K == 0) {
                sb.append(first).append(", ");
            } else {
                queue.offer(first);
            }
        }

            sb.delete(sb.length() - 2, sb.length());


        sb.append(">");
        System.out.println(sb);
    }

}