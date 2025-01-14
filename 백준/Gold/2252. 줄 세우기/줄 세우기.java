import java.io.IOException;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 학생 수
        int M = sc.nextInt(); // 키를 비교한 횟수

        int[] degree = new int[N + 1];
        List<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            graph.get(A).add(B);
            degree[B]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (Integer node : graph.get(current)) {
                degree[node]--;
                if (degree[node] == 0) queue.offer(node);
            }
        }

    }
}





