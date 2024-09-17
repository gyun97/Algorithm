import java.util.*;

class Solution {

    static int n, m, sum;
    static boolean visited[][];
    static char graph[][];
    static List<Integer> result;

    public int[] solution(String[] maps) {

        n = maps.length; // 세로
        m = maps[0].length(); // 가로
        visited = new boolean[n][m];
        graph = new char[n][m];
        result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(graph[i][j]) && !visited[i][j]) {
                    sum = 0;
                    bfs(i, j);
                    result.add(sum);
                }
            }
        }

        Collections.sort(result);

        if (result.isEmpty()) {
            return new int[]{-1};
        }

        return result.stream().mapToInt(i -> i).toArray();

    }

    private void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        sum += Character.getNumericValue(graph[x][y]);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && Character.isDigit(graph[nx][ny])) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += Character.getNumericValue(graph[nx][ny]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] maps = {"X591X", "X1X5X", "X231X", "1XXX1"};
        System.out.println(Arrays.toString(sol.solution(maps)));

    }


}