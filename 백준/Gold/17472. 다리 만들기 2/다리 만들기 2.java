import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Bridge implements Comparable<Bridge> {
    int start;
    int end;
    int weight;

    public Bridge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Bridge o) {
        return weight - o.weight;
    }

}

/*
최소 스패닝 트리 문제(BFS +
 */
public class Main {
    static int N, M, islandNum, total;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Bridge> pq = new PriorityQueue<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로 크기
        M = Integer.parseInt(st.nextToken()); // 가로 크기

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        /*
        1. 섬 번호 매기기 (Labeling)
        BFS/DFS로 각 섬에 번호 부여 (1번 섬, 2번 섬, …).
        이제 각 섬은 "정점"이 됨.
        */
        islandLabeling();

        parents = new int[islandNum + 1];
        for (int i = 1; i <= islandNum; i++) {
            parents[i] = i;
        }

        /*
        2. 다리 후보 탐색 (간선 + 가중치 생성)
        - 각 섬의 모든 땅 칸에서 상/하/좌/우로 직선으로 바다를 탐색.
        - 다른 섬을 만나면 다리 완성, 다리 길이는 탐색한 칸 수.
        - 다리 길이가 2 이상일 때만 유효.
        - (시작 섬, 도착 섬, 다리 길이) → 간선으로 저장.
        */
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    makeBridge(i, j, map[i][j]);
                }
            }
        }


        /*
        3. MST 실행
        만들어진 "섬 그래프"는 정점 ≤ 6개라 간선 수도 제한적임.
        이제 Kruskal(Union-Find)나 Prim으로 MST를 돌리면 됨.
         */
        mst();

//        System.out.println(Arrays.deepToString(map));
        System.out.println(total);
    }

    private static void mst() {
        int edgeUsed = 0;

        while (!pq.isEmpty() && edgeUsed < islandNum - 1) {
            Bridge cur = pq.poll();
            int start = cur.start;
            int end = cur.end;

            int a = find(start);
            int b = find(end);

            if (a != b) {
                union(a, b);
                edgeUsed++;
                total += cur.weight;
            }
        }

        if (edgeUsed != islandNum - 1) {
            total = - 1;
        }
    }

    private static void union(int a, int b) {
        if (a < b) {
            parents[b] = a;
        } else {
            parents[a] = b;
        }

    }

    private static int find(int node) {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }
        return parents[node];
    }

    private static void makeBridge(int x, int y, int num) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            int len = 0;
            while (true) {
                nx += dx[d];
                ny += dy[d];
                if (0 > nx || nx >= N || 0 > ny || ny >= M) break; // 범위 밖을 벗어나면 중단
                if (num == map[nx][ny]) break; // 같은 섬 만나면 중단
                if (map[nx][ny] > 0) {
                    if (len >= 2) {
                        pq.add(new Bridge(num, map[nx][ny], len));
                    }
                    break;
                }
                len++;
            }
        }
    }

    private static void islandLabeling() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islandNum++;
                    bfs(i, j);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandNum;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && map[nx][ny] != 0) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        map[nx][ny] = islandNum;
                    }
                }
            }
        }
    }

}

