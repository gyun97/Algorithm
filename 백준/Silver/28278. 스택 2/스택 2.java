import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    continue;
                case 2:
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                        continue;
                    } else {
                        sb.append(-1).append("\n");
                        continue;
                    }
                case 3:
                    sb.append(stack.size()).append("\n");
                    continue;
                case 4:
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                        continue;
                    } else {
                        sb.append(0).append("\n");
                        continue;
                    }
                case 5:
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                        continue;
                    } else {
                        sb.append(-1).append("\n");
                        continue;
                    }
            }
        }
        System.out.println(sb);
    }
}