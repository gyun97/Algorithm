import java.util.*;

class Solution {
    static int n, m;
    // static int[][] graph;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        // graph = new int[n][m];
        
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         graph[i][j] = maps[i][j];
        //     }
        // }
        
        bfs(0, 0, maps);
        
        System.out.println(Arrays.deepToString(maps));
            
           
        int answer = maps[n - 1][m - 1];
        if (answer == 1) return -1;
        return answer;
    }
    
    public void bfs(int x, int y, int[][] maps) {
        Queue<int[]> q = new ArrayDeque<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                
                if (0 <= nx && nx < n &&  0 <= ny && ny < m) {
                    if (maps[nx][ny] == 1) {
                        q.add(new int[]{nx, ny});
                        maps[nx][ny] = maps[curX][curY] + 1;
                    }
                    
                }
                
            }
        }
        
        
    }
}