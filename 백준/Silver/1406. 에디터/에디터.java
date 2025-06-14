import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<String> stack1 = new ArrayDeque<>();
        Deque<String> stack2 = new ArrayDeque<>();

        String[] init = br.readLine().split("");
        for (int i = 0; i < init.length; i++) {
            stack1.push(init[i]);
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            String order = input[0];
            if (order.equals("P")) {
                stack1.push(input[1]);
            } else if (order.equals("B") && !stack1.isEmpty()) {
                stack1.pop();
            } else if (order.equals("L") && !stack1.isEmpty()) {
                String s = stack1.pop();
                stack2.push(s);
            } else if (order.equals("D") && !stack2.isEmpty()) {
                String s = stack2.pop();
                stack1.push(s);
            }
        }

        while (!stack1.isEmpty()) {
            String s = stack1.pop();
            sb.append(s);
        }

        sb.reverse();

        while (!stack2.isEmpty()) {
            String s = stack2.pop();
            sb.append(s);
        }

        System.out.println(sb);
        
    }
}




