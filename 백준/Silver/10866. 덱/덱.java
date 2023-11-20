import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();


            switch (order) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.pollFirst()).append("\n");
                        break;
                    } else {
                        sb.append(-1).append("\n");
                        break;
                    }
                case "pop_back":
                    if(!deque.isEmpty()) {
                        sb.append(deque.pollLast()).append("\n");
                        break;
                    } else {
                        sb.append(-1).append("\n");
                        break;
                    }
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if (!deque.isEmpty()) {
                        sb.append(0).append("\n");
                        break;
                    } else {
                        sb.append(1).append("\n");
                        break;
                    }
                case "front":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peek()).append("\n");
                        break;
                    } else {
                        sb.append(-1).append("\n");
                        break;
                    }
                case "back":
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                        break;
                    } else {
                        sb.append(-1).append("\n");
                        break;
                    }

            }
           
        }
        System.out.println(sb);
    }

}





