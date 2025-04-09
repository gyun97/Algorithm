import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());  // 건물의 개수
            int K = Integer.parseInt(st.nextToken());  // 건물간의 건설 순서 규칙의 개수

            int[] D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            int[] degree = new int[N + 1];
            List<Integer>[] graph = new ArrayList[N + 1];
            List<Integer>[] reverseGraph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= N; i++) {
                reverseGraph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= K; i++) {
                String[] XY = br.readLine().split(" ");
                graph[Integer.parseInt(XY[0])].add(Integer.parseInt(XY[1]));
                degree[Integer.parseInt(XY[1])]++;

                reverseGraph[Integer.parseInt(XY[1])].add(Integer.parseInt(XY[0]));

            }

            int targetNum = Integer.parseInt(br.readLine());  // 승리하기 위해 지어야 하는 건물의 번호
            int[] dp = new int[N + 1];

            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i < N + 1; i++) {
                if (degree[i] == 0) {
                    q.offer(i);
                    dp[i] = D[i];
                }
            }


//            System.out.println(Arrays.toString(D));
//            System.out.println(Arrays.deepToString(graph));
//            System.out.println(Arrays.deepToString(reverseGraph));

            while (!q.isEmpty()) {

                int cur = q.poll();


                for (int node : graph[cur]) {
                    degree[node]--;
                    if (degree[node] == 0) {
                        q.add(node);
//                        dp[node] = Math.max(maxNum, dp[cur] + D[node]);
                        int max = 0;
                        if (reverseGraph[node].size() > 1) {
                            for (int candidate : reverseGraph[node]) {
                                max = Math.max(max, dp[candidate]);
                            }
                            dp[node] = max + D[node];
                        } else {
                            dp[node] = dp[cur] + D[node];
                        }
                    }

                }

//                if (degree[targetNum] == 0) {
////                    sumTime += D[targetNum];
//                    break;
//                }

            }

//            System.out.println("dp:" + Arrays.toString(dp));
//            System.out.println("answer:" + dp[targetNum]);
            sb.append(dp[targetNum]).append("\n");
        }
        System.out.println(sb);


    }


}

