import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class City {
    int end; // 목적지(노드)
    int weight; // 간선 가중치

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}


public class Main {

    static int N, M;
    static List<ArrayList<City>> graph;
    static long[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시(노드)의 개수
        M = Integer.parseInt(st.nextToken()); // 버스 노선(간선)의 개수

        graph = new ArrayList<>(); // 해당 노드의 인접 도시들을 담는 인접 리스트
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new City(end, weight));
        }

        /*
        간선의 개수(계산 반복 횟수)가 최대 6000개이고, 가중치가 최하 -10000이기 때문에
        int로 하면 int의 범위 초과될 수 있음
         */
        dist = new long[N + 1]; // 시작 노드에서 해당 노드까지의 최단 거리 저장 배열
        Arrays.fill(dist, INF);

        if (bellmanFord(1)) { // true이면
            sb.append(-1).append("\n"); // 음의 사이클 존재해서 최단 거리 구할 수 X
        } else { // 음의 사이클 존재하지 않는다면
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) sb.append(-1).append("\n"); // 시작점에서 해당 노드로 갈 수 없는 경우
                else sb.append(dist[i]).append("\n");
            }

        }
        System.out.println(sb);

    }

    private static boolean bellmanFord(int start) {
        dist[start] = 0;
        boolean update = false;

        /*
        벨만 포드는 간선의 개수가 최대 (노드 - 1)
        N개 이상이면 무조건 음의 사이클이 존재한다는 뜻이어서 사이클을 돌수록 최단 거리가 무한히 줄기 때문에
        특정 노드들의 최단 거리를 구할 수 없다.
         */
        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for (City city : graph.get(j)) {
                    if (dist[j] == INF) {
                        break;
                    }

                    if (dist[city.end] > dist[j] + city.weight) {
                        dist[city.end] = dist[j] + city.weight; // 더 짧은 최단 거리로 갱신
                        update = true;
                    }
                }
            }
            if (!update) break; // 아무 노드도 바뀌지 않는다면 relaxation(최단거리 완화) 끝난 거여서 바로 종료

        }

        if (update) { // N - 1번까지도 relaxation 이루어졌다면 N번째 시행해서 음의 사이클 존재하는지 확인
            for (int i = 1; i <= N; i++) {
                for (City city : graph.get(i)) {
                    if (dist[i] == INF) { // 시작 노드와 이어이지 않는 노드의 경우
                        break;
                    }

                    if (dist[city.end] > dist[i] + city.weight) { // N번째에도 relaxation된다면 음의 사이클 존재
                        return true; // 음의 사이클 존재 O
                    }

                }
            }
        }
        return false; // 음의 사이클 존재 X
    }

}