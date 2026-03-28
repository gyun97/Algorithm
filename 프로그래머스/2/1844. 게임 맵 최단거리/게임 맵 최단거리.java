import java.util.*;

class Solution {
    static Queue<int[]> q;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int n, m;
    
    public int solution(int[][] maps) {
        
        q = new ArrayDeque<>();
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[maps.length][maps[0].length];
                
        int answer = bfs(maps, 0, 0);
        return answer;
    }
    
    public int bfs(int[][] maps, int x, int y) {
        visited[x][y] = true;
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = curX + dx[d];
                int ny = curY + dy[d];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && visited[nx][ny] != true && maps[nx][ny] != 0) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[curX][curY] + 1;       
                }
            }
            if (maps[n - 1][m - 1] > 1) return maps[n - 1][m - 1];
        }
        return -1; 
    }
}