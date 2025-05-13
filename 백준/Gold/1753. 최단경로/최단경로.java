import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int end;
    int weight;

    public Edge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

public class Main {

    static Integer INF = Integer.MAX_VALUE;
    static int V, E;
    static List<List<Edge>> graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 노드 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new ArrayList<>();
        int startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        visited = new boolean[V + 1];
        Arrays.fill(visited, false);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
        }

        dijkstra(startNode);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static void dijkstra(int startNode) {
        Queue<Edge> pq = new PriorityQueue<>();
        dist[startNode] = 0;
        pq.add(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int cur = curEdge.end;

            if (!visited[cur]) {
                visited[cur] = true;
            }

            for (Edge nextEdge : graph.get(cur)) {
                if (!visited[nextEdge.end] && dist[nextEdge.end] > dist[cur] + nextEdge.weight) {
                    dist[nextEdge.end] = dist[cur] + nextEdge.weight;
                    pq.add(new Edge(nextEdge.end, dist[nextEdge.end]));
                }

            }


        }

    }
}
