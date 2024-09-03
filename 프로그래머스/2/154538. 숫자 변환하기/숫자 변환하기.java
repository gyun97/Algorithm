import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {

        return bfs(x, y, n);
    }

    public static int bfs(int x, int y, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        queue.add(new int[]{x, 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curCount = current[1];

            if (curX == y) return curCount;

            if (curX < y) {
                for (int i = 0; i < 3; i++) {
                    int[] dx = {curX + n, curX * 2, curX * 3};
                    int nx = dx[i];
                    if (nx > y) break;

                    if (!visited[nx]) {
                        queue.add(new int[]{nx, curCount + 1});
                        visited[nx] = true;
                    }
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;
        Solution sol = new Solution();
        System.out.println(sol.solution(x, y, 5));
    }
}