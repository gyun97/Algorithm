import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int num;
    int time;

    public Node(int num, int time) {
        this.num = num;
        this.time = time;
    }
}

public class Main {

    static int N, K;
    static boolean[] visited;
    static final int MAX = 100000;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[MAX + 1];
        min = Integer.MAX_VALUE;

        bfs();
        System.out.println(min);
    }

    // 0 - 1 BFS(가중치가 0 또는 1인 최단 경로 문제)
    private static void bfs() {
        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(N, 0));
        visited[N] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.num] = true;

            if (cur.num == K) min = Math.min(min, cur.time);

            if (cur.num * 2 <= MAX && !visited[cur.num * 2]) q.add(new Node(cur.num * 2, cur.time));
            if (cur.num + 1 <= MAX && !visited[cur.num + 1]) q.add(new Node(cur.num + 1, cur.time + 1));
            if (cur.num - 1 >= 0 && !visited[cur.num - 1]) q.add(new Node(cur.num - 1, cur.time + 1));
        }
    }
}



