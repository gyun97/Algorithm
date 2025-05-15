import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                answer++;
            }
        }
    
        return answer;
    }
    
    public void dfs(int computer, boolean[] visited, int[][] computers) {
        visited[computer] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[computer][i] == 1) {
                dfs(i, visited, computers);
            }
        }
        
    }
}