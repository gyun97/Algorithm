import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, V, M;

    static int[][] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         N = Integer.parseInt(st.nextToken());  // 정점 수
         M = Integer.parseInt(st.nextToken());  // 간선 수
         V = Integer.parseInt(st.nextToken());  // 시작 노드 번호

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }



        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int V) {
        visited[V] = true;
        sb.append(V).append(" ");

        for (int i = 1; i < N+1; i++) {
            if (graph[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        queue.add(V);
        visited[V] = true;
        while (!queue.isEmpty()) {
            V = queue.poll();
            sb.append(V).append(" ");
            for (int i = 1; i <= N; i++) {
                if ( graph[V][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

    }


}
