import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int[] result = new int[N + 1]; // 결과(한 번에 가장 많은 해킹한 컴퓨터 번호)를 저장할 배열

        for (int i = 1; i <= N; i++) {
            int count = bfs(i); // i 노드에서 bfs로 그래프 탐색 시작하면 몇 개의 노드로 이동가능한지
            result[i] = count;
        }

        int maxCount = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= N; i++) {
            if (maxCount <= result[i]) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);

    }

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        int count = 0; // start 노드에서 bfs로 탐색을 시작하면 몇 개의 노드를 이동할 수 있는지(몇 개의 컴퓨터를 해킹할 수 있는지)
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) { // 아직 해킹되지 않은 컴퓨터라면(아직 방문 x 노드)
                    count++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}



