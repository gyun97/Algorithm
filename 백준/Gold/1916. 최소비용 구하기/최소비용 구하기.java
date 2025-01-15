import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

public class Main {

    static int N, M;
    static List<ArrayList<Node>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 노드(도시)의 개수
        M = Integer.parseInt(br.readLine()); // 엣지(버스 노선)의 개수

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) { // 0부터 N까지 초기화
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) { // M개의 엣지 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, weight));
        }

        dist = new int[N + 1]; // 최단 거리 배열
        Arrays.fill(dist, INF);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        sb.append(dijkstra(startPos, endPos));
        System.out.println(sb);
    }

    private static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int currentPos = currentNode.end;

            if (dist[currentPos] < currentNode.weight) continue; // 이미 처리된 노드는 스킵

            for (Node node : graph.get(currentPos)) {
                if (dist[node.end] > dist[currentPos] + node.weight) {
                    dist[node.end] = dist[currentPos] + node.weight;
                    pq.offer(new Node(node.end, dist[node.end]));
                }
            }
        }
        return dist[end] == INF ? -1 : dist[end]; // 도달 불가 시 -1 반환
    }
}
