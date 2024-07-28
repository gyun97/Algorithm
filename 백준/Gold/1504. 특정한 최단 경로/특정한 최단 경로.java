import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }

}


class Main {

    static int N, E;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] visited;
    static final int INF = 200000000;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        visited = new boolean[N + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int mandatory1 = Integer.parseInt(st.nextToken());
        int mandatory2 = Integer.parseInt(st.nextToken());

        int result1 = 0;

        result1 += dijkstra(1, mandatory1);
        result1 += dijkstra(mandatory1, mandatory2);
        result1 += dijkstra(mandatory2, N);

        int result2 = 0;
        result2 += dijkstra(1, mandatory2);
        result2 += dijkstra(mandatory2, mandatory1);
        result2 += dijkstra(mandatory1, N);

        int answer = (result2 >= INF && result1 >= INF) ? -1 : Math.min(result1, result2);
        sb.append(answer);
        System.out.println(sb);

    }


    public static int dijkstra(int start, int end) {

        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.end;
            if (!visited[current]) {
                visited[current] = true;

                for (Node node : list.get(current)) {
                    if (!visited[node.end] && dist[node.end] > dist[current] + node.weight) {
                        dist[node.end] = dist[current] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }

                }
            }
        }
        return dist[end];
    }
}