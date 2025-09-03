import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer;
    static int[] durability;
    static int[] weight;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        durability = new int[N];
        weight = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0); // 0번째 계란부터 시작
        System.out.println(answer);
    }


    private static void dfs(int idx) {
        if (idx == N) {
            int broken = 0;
            for (int i = 0; i < N; i++) {
                if (durability[i] <= 0) broken++;
            }

            answer = Math.max(answer, broken);
            return;
        }

        if (durability[idx] <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (idx == i || durability[i] <= 0) continue;

            hit = true;
            durability[idx] -= weight[i];
            durability[i] -= weight[idx];

            dfs(idx + 1);

            durability[idx] += weight[i];
            durability[i] += weight[idx];
        }

        if (!hit) {
            dfs(idx + 1);
        }
        
    }

}
