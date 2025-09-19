import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, mp, mf, ms, mv;
    static int[][] A; // 단백질, 지방, 탄수화물, 비타민, 비용
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken()); // 단백질
        mf = Integer.parseInt(st.nextToken()); // 지방
        ms = Integer.parseInt(st.nextToken()); // 탄수화물
        mv = Integer.parseInt(st.nextToken()); // 비타민

        A = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, new int[4], new ArrayList<>());

        if (minCost == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
            for (int i = 0; i < answer.size(); i++) {
                System.out.print(answer.get(i));
                if (i < answer.size() - 1) System.out.print(" ");
            }
        }

    }

    static void dfs(int idx, int cost, int[] cur, List<Integer> chosen) {
        if (cost > minCost) return;

        if (cur[0] >= mp && cur[1] >= mf && cur[2] >= ms && cur[3] >= mv) {
            if (cost < minCost || (cost == minCost && isLexicoSmaller(chosen, answer))) {
                minCost = cost;
                answer = new ArrayList<>(chosen);
            }
        }

        if (idx == N) return;

        // 1) 현재 재료 선택
        for (int i = 0; i < 4; i++) cur[i] += A[idx][i];
        chosen.add(idx + 1);
        dfs(idx + 1, cost + A[idx][4], cur, chosen);

        for (int i = 0; i < 4; i++) cur[i] -= A[idx][i];
        chosen.remove(chosen.size() - 1);

        // 2) 현재 재료 선택 안 함
        dfs(idx + 1, cost, cur, chosen);



    }

    private static boolean isLexicoSmaller(List<Integer> a, List<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }


}
