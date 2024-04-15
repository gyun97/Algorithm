import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int count = 1;

        ArrayList<String> answer = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            while (a >= count) {
                stack.add(count);
                answer.add("+");

                count++;
            }

            if (a == stack.lastElement()) {
                stack.pop();
                answer.add("-");

            } else {
                answer.clear();
                answer.add("NO");
                break;
            }

        }
        
        answer.forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
        
    }


}
