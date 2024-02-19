import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> my_deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    my_deque.addFirst(Integer.parseInt(st.nextToken()));
                    continue;
                case 2:
                    my_deque.add(Integer.parseInt(st.nextToken()));
                    continue;
                case 3:
                    if (!(my_deque.isEmpty())) {
                        sb.append(my_deque.pollFirst()).append("\n");
                        continue;
                    } else {
                        sb.append(-1).append("\n");
                        continue;
                    }
                case 4:
                    if (!(my_deque.isEmpty())) {
                        sb.append(my_deque.pollLast()).append("\n");
                        continue;
                    } else {
                        sb.append(-1).append("\n");
                        continue;
                    }
                case 5:
                    sb.append(my_deque.size()).append("\n");
                    continue;
                case 6:
                    if (!(my_deque.isEmpty())) {
                        sb.append(0).append("\n");
                        continue;
                    } else {
                        sb.append(1).append("\n");
                        continue;
            }
                case 7:
                    if (!(my_deque.isEmpty())) {
                        sb.append(my_deque.peek()).append("\n");
                        continue;
                    } else {
                        sb.append(-1).append("\n");
                        continue;
                    }
                case 8:
                    if (!(my_deque.isEmpty())) {
                        sb.append(my_deque.peekLast()).append("\n");
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