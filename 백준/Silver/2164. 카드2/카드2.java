import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i < N+1; i++){
            queue.offer(i);
        }

        while (queue.size() > 1){
            queue.poll();
            int last = queue.poll();
            queue.offer(last);
        }

        sb.append(queue.peek());
        System.out.println(sb);
        
    }

}