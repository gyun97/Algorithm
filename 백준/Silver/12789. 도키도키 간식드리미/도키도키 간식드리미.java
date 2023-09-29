import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int target = 1;
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

          while (!queue.isEmpty()){
              int queue_element = queue.poll();
              if (queue_element == target){
                  target += 1;
              }
              else{
                  stack.push(queue_element);
              }
              while (!stack.isEmpty()){
                  int stack_element = stack.pop();
                  if (stack_element== target){
                      target += 1;
                  }
                  else{
                      stack.push(stack_element);
                      break;
                  }
              }

        }
        if (stack.isEmpty()){
            sb.append("Nice");
        }
        else{
            sb.append("Sad");
        }
        System.out.println(sb);
    }
}