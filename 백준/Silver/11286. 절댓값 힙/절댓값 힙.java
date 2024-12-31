import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            // 절댓값이 작은 수 우선
            // 절댓갑이 같은 경우 음수 우선
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            return first_abs - second_abs;
        });

        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            } else {
                priorityQueue.add(x);
            }
        }
        System.out.println(sb);

    }
}
