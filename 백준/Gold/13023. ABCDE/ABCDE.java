import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static int N, M;
    static List<Integer>[] friendship;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        friendship = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            friendship[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendship[a].add(b);
            friendship[b].add(a);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }

        System.out.println(found ? 1 : 0);

    }

    private static void dfs(int node, int depth) {
        if (found) return;
        if (depth == 5) {
            found = true;
            return;
        }

        visited[node] = true;
        for (int next : friendship[node]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }

        }

        visited[node] = false;



    }

}


