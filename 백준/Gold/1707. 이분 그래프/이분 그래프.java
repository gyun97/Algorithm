import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] check;
    static boolean isEven;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점의 개수
            E = Integer.parseInt(st.nextToken()); // 간선의 개수
            graph = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            isEven = true;

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            while (E-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            // 그래프가 여러 개로 나뉘어져 있는 경우를 대비하여 모든 노드에서 dfs 실행해야 한다.
            for (int i = 1; i <= V; i++) {
                if (isEven) dfs(i);
                else break;

            }
            if (isEven) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int startNode) {
        visited[startNode] = true; // 방문 표시
        for (int neighborNode : graph[startNode]) { // 해당 정점의 인접 노드들 순차 탐색
            if (!visited[neighborNode]) { // 인접 노드가 아직 방문 전이라면
                check[neighborNode] = (check[startNode] + 1) % 2; // 0 혹은 1의 집합으로 체크 (직전의 노드와 다른 집합으로 분류)
                dfs(neighborNode); // 해당 인접 노드의 다른 인접 노드 탐색 반복
            } else { // 이미 인접 노드가 방문된 상태이고
                if (check[neighborNode] == check[startNode]) { // 인접 노드와 집합도 같다면
                    isEven = false; // 이분 그래프가 아니다
                }
            }
        }

    }
}





