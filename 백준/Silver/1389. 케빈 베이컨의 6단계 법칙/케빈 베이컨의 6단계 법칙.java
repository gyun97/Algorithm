import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static long[][] graph;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new long[N + 1][N + 1]; // 노드 연결 정보를 나타내는 2차원 인접 행렬
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) graph[i][j] = 0;  // 자기 자신과의 거리는 0
                else graph[i][j] = INF; // 다른 노드과의 거리는 무한대로 초기화
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1; // 연결되어 있는 인접 노드들끼리는 인접 행렬에 0으로 표시(무방향 그래프이기 때문에 양방향 표시)

        }

        long minCount = INF; // 현재의 최소 케빈 베이컨 수
        int minIdx = 0; // 현재의 최소 유저

        floydWarshall();
        
        for (int i = 1; i <= N; i++) {
            long count = Arrays.stream(graph[i]).sum();
            if (minCount > count) {
                minCount = count;
                minIdx = i;
            }
        }

        sb.append(minIdx);
        System.out.println(sb);

    }

    private static void floydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
//                    if (graph[i][j] > graph[i][k] + graph[k][j]) graph[i][j] = graph[i][k] + graph[k][j];
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

    }
}