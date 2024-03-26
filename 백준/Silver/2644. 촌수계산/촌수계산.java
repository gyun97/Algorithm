import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    static int n, a, b, m, x, y;
    static int[][] graph;
    static int[] count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }

        count = new int[n + 1];

        dfs(a);

        System.out.println(count[b] > 0 ? count[b] : -1);
        
    }

    private static int dfs(int a) {
        for (int i = 1; i <= n; i++) {
            if (graph[a][i] == 1 && count[i] == 0) {
                count[i] = count[a] + 1;
                dfs(i);
            }
        }

        return count[b];
    }

}