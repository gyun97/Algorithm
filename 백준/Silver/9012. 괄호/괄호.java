import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] str = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("(")) {
                    stack.push(str[i]);
                } else {
                    if (str[i].equals(")") && stack.contains("(")) {
//                        stack.remove("(");
                        stack.pop();
                    } else {
                        stack.push(str[i]);
                    }
                }
            }
            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }

        }


        System.out.println(sb);

    }

}