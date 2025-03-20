import java.util.*;

class Solution {
    
    
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            graph[winner][loser] = 1;
            graph[loser][winner] = -1;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1;i <= n; i++) {
                for (int j = 1;j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                
                }
            }
        }
        // System.out.println(Arrays.deepToString(graph));
        
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] != 0) count++;
            }
            if (count == n - 1) {
                answer++;
                
            }
        }
        
        return answer;
    }
}