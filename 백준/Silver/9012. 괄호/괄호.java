import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());



        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String vps = br.readLine();
            for (int j = 0; j < vps.length(); j++) {
                char c = vps.charAt(j);
                if (c == '(') {
                    stack.push(c);
                }
                else {
                    int last = vps.length() - 1;
                    if (!stack.isEmpty() && stack.lastElement() == '(')  {
                        stack.pop();
                    }
                    else{
                        stack.push(c);
                    }

                }
            }
            if (stack.isEmpty()) {
                sb.append("YES\n");
            }
            else{
                sb.append("NO\n");
            }
            
        }

        System.out.println(sb);
        
    }
}





