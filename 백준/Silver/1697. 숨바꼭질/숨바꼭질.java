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

    static StringBuilder sb = new StringBuilder();

    static int N, K;
    static int MAX = (int) Math.pow(10, 5) + 1;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new int[MAX];

        bfs(N);
        System.out.println(sb);


    }

    public static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            x = queue.poll();
            if (x == K) {
                sb.append(visited[x]);
                break;
            }
            int[] dx = {x - 1, x + 1, x * 2};
            for (int nx : dx) {
                if ((0 <= nx && nx < MAX) && (visited[nx] == 0)) {
                    visited[nx] = visited[x] + 1;
                    queue.add(nx);
                }
            }
        }
    }


}