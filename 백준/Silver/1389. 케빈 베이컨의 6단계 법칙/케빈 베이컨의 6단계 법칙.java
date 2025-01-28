import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 유저(노드)의 수
        M = Integer.parseInt(st.nextToken()); // 인맥(간선)의 수

        graph = new ArrayList[N + 1]; // 유저(노드)간의 관계가 저장된 인맥(그래프) - 인접 배열
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            /*무방향 그래프이기 때문에 양쪽에 모두 저장*/
            graph[a].add(b);
            graph[b].add(a);
        }

        int minCount = Integer.MAX_VALUE; // 현재까지의 최소 케빈 베이컨의 수
        int minIdx = 0; // 현재까지의 최소 케빈 베이컨의 수를 가진 사람

        for (int i = 1; i <= N; i++) {
            // bfs: 해당 유저(노드) i의 케빈 베이컨의 수를 구하기 위한 bfs
            int count = bfs(i);
            if (minCount > count) {
                minCount = count;
                minIdx = i;
            }
        }
        sb.append(minIdx);
        System.out.println(sb);

    }

    private static int bfs(int user) {
        int count = 0; // 해당 유저(노드)의 현재까지의 케빈 베이컨 수 카운트
        int[] dist = new int[N + 1]; // 해당 유저에서 각 다른 유저들과의 단계(거리) 수를 저장하는 배열
        Arrays.fill(dist, -1); // 다른 모든 유저들간의 거리 -1로 초기화(-1이면 해당 유저과의 거리는 아직 계산하지 않은 거고 0이면 유저 본인)
        Queue<Integer> queue = new ArrayDeque<>(); // bfs 수행을 위한 큐

        queue.offer(user);
        dist[user] = 0; // 유저 자기 자신과의 거리는 0

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph[cur]) {
                if (dist[next] == -1) { // 아직 거리를 계산하지 않은 인접 유저라면
                    dist[next] = dist[cur] + 1;
                    count += dist[cur];
                    queue.offer(next);
                }
            }
        }

        return count;
    }


}