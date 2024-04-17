import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;

            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int k = Integer.parseInt(st.nextToken());
                queue.offer(k);
            }


            while (!queue.isEmpty()) {
                int max = Collections.max(queue);
                int x = queue.poll();
                M--;
                if (max == x) {
                    count++;
                    if (M < 0) {
                        sb.append(count).append("\n");
                        break;
                    }

                } else {
                    queue.add(x);
                    if (M < 0) {
                        M = queue.size() - 1;
                    }

                }

            }
        }

        System.out.println(sb);


    }



}
