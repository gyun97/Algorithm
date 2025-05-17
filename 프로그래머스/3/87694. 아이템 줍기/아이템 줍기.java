import java.util.*;

class Solution {
    
    private static final int SIZE = 102;
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        int[][] map = new int[SIZE][SIZE];
        boolean[][] visited = new boolean[SIZE][SIZE];
        
        for (int[] rect: rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            // Step 1: 테두리와 내부 채우기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
            
        }
            
        // Step 2: 내부 지우기 (테두리만 남기기)        
        for (int[] rect: rectangle) {
        int x1 = rect[0] * 2;
        int y1 = rect[1] * 2;
        int x2 = rect[2] * 2;
        int y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
    }    
            int answer = bfs(map, visited, characterX, characterY, 0, itemX, itemY);
        return answer;
            
    }
    
    // Step 3: BFS
    public int bfs(int[][] map, boolean[][] visited, int characterX, int characterY, int count, int itemX, int itemY) {
        Queue<int[]> q = new ArrayDeque<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCount = cur[2];
            
            if (curX == itemX * 2 && curY == itemY * 2) return curCount / 2;
            
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        q.add(new int[]{nx, ny, curCount + 1});
                        visited[nx][ny] = true;
                    }
                }
                    
            }
        }
        
        
     return 0;   
    }
}