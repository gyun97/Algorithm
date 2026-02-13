class Solution {
    
    static int answer;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        visited = new boolean[dungeons.length];
        dfs(0, k, dungeons);
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        for (int i = 0; i < dungeons.length; i++) {
            int minTired = dungeons[i][0];
            int tired = dungeons[i][1];
            if (visited[i] || k < minTired) continue;
            
            visited[i] = true;
            dfs(depth + 1, k - tired, dungeons);
            visited[i] = false;
        }
        
        answer = Math.max(depth, answer);
        
        
    }
}