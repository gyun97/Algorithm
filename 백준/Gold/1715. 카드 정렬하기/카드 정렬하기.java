import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;

        // N이 1일 경우 비교 자체가 없음
        if (N == 1) {
            System.out.println(0);
            return;
        }

        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            int sum = num1 + num2;
            answer += sum;
            pq.add(sum);
        }

        System.out.println(answer);
    }
}
