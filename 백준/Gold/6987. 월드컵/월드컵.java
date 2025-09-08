import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<int[]> matches = new ArrayList<>();
    static int[] win = new int[6];
    static int[] lose = new int[6];
    static int[] draw = new int[6];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches.add(new int[]{i, j});
            }
        }

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            win = new int[6];
            draw = new int[6];
            lose = new int[6];
            for (int j = 0; j < 6; j++) {
                win[j] = Integer.parseInt(st.nextToken());
                draw[j] = Integer.parseInt(st.nextToken());
                lose[j] = Integer.parseInt(st.nextToken());
            }
            if (dfs(0)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);

    }

    private static boolean dfs(int matchIdx) {
        if (matchIdx == 15) {
            return checkAllZero();
        }

        int a = matches.get(matchIdx)[0];
        int b = matches.get(matchIdx)[1];

        // 1) a승 b패
        if (win[a] > 0 && lose[b] > 0) {
            win[a]--; lose[b]--;
            if (dfs(matchIdx + 1)) return true;
            win[a]++; lose[b]++;
        }

        // 2) b승 a패
        if (win[b] > 0 && lose[a] > 0) {
            win[b]--; lose[a]--;
            if (dfs(matchIdx + 1)) return true;
            win[b]++; lose[a]++;
        }

        // 3) 무승부
        if (draw[b] > 0 && draw[a] > 0) {
            draw[b]--; draw[a]--;
            if (dfs(matchIdx + 1)) return true;
            draw[b]++; draw[a]++;
        }

        return false; // 세 경우 다 실패하면 불가능
    }

    private static boolean checkAllZero() {
        if (Arrays.stream(win).anyMatch(i -> i != 0)) {
            return false;
        }

        if (Arrays.stream(lose).anyMatch(i -> i != 0)) {
            return false;
        }

        if (Arrays.stream(draw).anyMatch(i -> i != 0)) {
            return false;
        }

        return true;
    }
}
