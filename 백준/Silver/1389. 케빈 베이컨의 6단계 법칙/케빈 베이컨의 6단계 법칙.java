import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {
    static int N, M;
    static int[][] graph;
    static boolean visited[];
    static int[] count;
    static int[] result;
    static int sum;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        result = new int[N];

        for (int j = 1; j < N + 1; j++) {
            visited = new boolean[N + 1];
            count = new int[N + 1];
            sum = 0;
            result[j - 1] = bfs(j);
        }



//        int answer = Arrays.stream(result).min().getAsInt();
//        Arrays.stream(result).forEach(System.out::println);

        int answer = Arrays.stream(result).min().getAsInt();
        int num = 1;
        for (int i = 0; i < result.length; i++) {
            if (result[i] == answer) {
                System.out.println(num);
                break;
            }
            num++;
        }

        
    }

    public static int bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            x = queue.poll();
            for (int i = 1; i < N + 1; i++) {
                if (!visited[i] && graph[x][i] == 1) {
                    count[i] = count[x] + 1;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        sum = Arrays.stream(count).sum();
//        System.out.println(sum);
        return sum;
    }


}