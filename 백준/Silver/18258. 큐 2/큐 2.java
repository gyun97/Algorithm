import java.io.*;
import java.util.*;

public class Main {
    static int last;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()){
                case "push":
                    last = Integer.parseInt(st.nextToken());
                    queue.offer(last);
                    break;
                case "pop":
                    if (!queue.isEmpty()){
                        sb.append(queue.poll()).append("\n");
                }
                    else{
                        sb.append((-1)).append("\n");
                    }
                    break;
                case "size":
                    sb.append((queue.size())).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if (!queue.isEmpty()){
                        sb.append(queue.peek()).append("\n");
                    }
                    else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (queue.isEmpty()){
                        sb.append(-1).append("\n");
                    }
                    else {
                        sb.append(last).append("\n");
                        }
                    break;
            }

            }
        System.out.println(sb);
    }

    }