import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }

}

public class Main {
    static int N, M, X;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, weight));
        }

        int[] results = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            boolean[] visited = new boolean[N + 1];

            if (i == X) continue;
            dijkstra(i, dist, visited, X);
            int result = dist[X];
            results[i] = result;

        }

        for (int i = 1; i <= N; i++) {
            int[] dist = new int[N + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            boolean[] visited = new boolean[N + 1];

            int result = dijkstra(X, dist, visited, i);
            results[i] += result;
        }

        int answer = Arrays.stream(results).max().getAsInt();

//        System.out.println(Arrays.toString(results));
        System.out.println(answer);

    }

    private static int dijkstra(int start, int[] dist, boolean[] visited, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.end]) {
                visited[cur.end] = true;
            }

            for (Node node : graph[cur.end]) {
                if (dist[node.end] > dist[cur.end] + node.weight && !visited[node.end]) {
                    dist[node.end] = dist[cur.end] + node.weight;
                    pq.add(new Node(node.end, dist[node.end]));
                }
            }

        }
        return dist[end];

    }
}












