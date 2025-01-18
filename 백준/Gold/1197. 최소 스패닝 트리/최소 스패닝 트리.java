import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }

}


public class Main {
    static int V, E;
    static int[] parent;
    static Queue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수

        parent = new int[V + 1];
        for (int i = 0; i <= V; i++) {
            parent[i] = i;
        }

        pq = new PriorityQueue<>();
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        int totalSum = 0;
        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int start = curNode.start;
            int end = curNode.end;
            int weight = curNode.weight;

            if (!checkSame(start, end)) {
                totalSum += weight;
                union(start, end);
            }

        }
        sb.append(totalSum);
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        }
        return false;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);

    }

}