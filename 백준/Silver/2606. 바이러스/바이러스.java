import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine()); // 컴퓨터(노드)의 수
        M = Integer.parseInt(br.readLine()); // 간선의 수

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 체크 배열 초기화
        visited = new boolean[N + 1];

        // bfs 실행(bfs로 그래프 탐색해서 1번 노드와 몇 개의 노드가 연결되어 있는지 확인)
        sb.append(bfs(1));
        System.out.println(sb);

    }

    private static int bfs(int x) {
        int count = 0; // 1번 컴퓨터가 감염시킨 컴퓨터 숫자
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    count++;
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return count;

    }
}