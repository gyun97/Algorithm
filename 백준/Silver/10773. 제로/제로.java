import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < K; i++){
            int x = Integer.parseInt(br.readLine());

            if (x == 0){
                stack.pop();
            }
            else{
                stack.push(x);
            }
        }

        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        sb.append(sum);

        System.out.println(sb);
    }
}