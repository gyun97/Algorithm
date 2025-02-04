import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                answer += 1;
            } else if (num > 1) {
                positive.offer(num);
            } else {
                negative.offer(num);
            }
        }

        while (!positive.isEmpty()) {
            int cur = positive.poll();
            if (!positive.isEmpty()) {
                int next = positive.poll();
                answer += cur * next;
            } else {
                answer += cur;
            }
        }

        while (!negative.isEmpty()) {
            int cur = negative.poll();
            if (!negative.isEmpty()) {
                int next = negative.poll();
                answer += cur * next;
            } else {
                answer += cur;
            }
        }

        System.out.println(answer);
    }

}
