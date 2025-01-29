import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static List<Integer>[] graph;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 개수

        // 인접 리스트 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N + 1]; // 노드 방문 여부 배열 초기화
        result = new ArrayList<>(); // 방문 노드 담을 결과 리스트 초기화

        dfs(V).forEach(element -> sb.append(element).append(" ")); // dfs 실행
        sb.append("\n");
        bfs(V).forEach(element -> sb.append(element).append(" ")); // bfs 실행
        System.out.println(sb);

    }

    private static List<Integer> dfs(int x) {
        result.add(x);
        visited[x] = true;
        Collections.sort(graph[x]);
        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        return result;
    }

    private static List<Integer> bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        visited = new boolean[N + 1];
        result.add(start);
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            Collections.sort(graph[cur]);
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    result.add(next);
                    visited[next] = true;
                    queue.offer(next);
                }

            }

        }
        return result;
    }
}