import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] board = new char[5][5];
    static int answer = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        combination(0, 0, new int[7]); // 25명 중 7명 뽑기
        System.out.println(answer);
    }

    // 25칸 중 7칸 선택 (조합)
    private static void combination(int start, int depth, int[] selected) {
        if (depth == 7) {
            check(selected);
            return;
        }

        for (int i = start; i < 25; i++) {
            selected[depth] = i;
            combination(i + 1, depth + 1, selected);
        }
    }

    // 조건 검사
    private static void check(int[] selected) {
        List<int[]> positions = new ArrayList<>();
        int sCount = 0;

        for (int idx : selected) {
            int x = idx / 5;
            int y = idx % 5;
            positions.add(new int[]{x, y});
            if (board[x][y] == 'S') sCount++;
        }

        // 'S' 최소 4명 조건 불만족
        if (sCount < 4) return;

        // DFS 연결성 검사
        boolean[] visited = new boolean[7];
        dfs(0, positions, visited); 

        int cnt = 0;
        for (boolean v : visited) {
            if (v) cnt++;
        }

        if (cnt == 7) answer++;
    }

    // DFS로 연결된 칸 수 검사
    private static void dfs(int idx, List<int[]> positions, boolean[] visited) {
        visited[idx] = true;
        int[] cur = positions.get(idx);

        for (int i = 0; i < 7; i++) {
            if (!visited[i]) {
                int[] next = positions.get(i);
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx == next[0] && ny == next[1]) {
                        dfs(i, positions, visited);
                        break; // 찾았으면 더 돌 필요 없음
                    }
                }
            }
        }
    }
}
