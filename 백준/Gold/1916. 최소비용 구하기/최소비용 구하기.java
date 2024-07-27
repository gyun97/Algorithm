import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int cost;

    Node(int end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

class Main {

    static int N, M; // N = 도시 개수, M = 버스 개수
    static ArrayList<ArrayList<Node>> list; // 인접리스트
    static int[] dist; // 시작점에서 각 지점까지의 최단 거리
    static boolean[] visited; // 방문 처리 여부


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 도시의 개수
        M = Integer.parseInt(br.readLine()); // 버스의 개수


        list = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, cost));

        }


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        sb.append(dijkstra(startPos, endPos));
        System.out.println(sb);


    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
//        boolean[] visited = new boolean[N + 1];
        priorityQueue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int current = currentNode.end;

            if (!visited[current]) {
                visited[current] = true;

                for (Node node : list.get(current)) {
                    if (!visited[node.end] && dist[node.end] > dist[current] + node.cost) {
                        dist[node.end] = dist[current] + node.cost;
                        priorityQueue.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }

}
