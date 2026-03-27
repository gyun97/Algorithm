import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        
        graph = new List[n + 1];
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph[i + 1].add(j + 1);
                }
            }
        }
        
        System.out.println(Arrays.deepToString(graph));
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) bfs(i);
        }
        
        return answer;
    }
    
    public void bfs(int start) {
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int neighbor : graph[cur]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        answer++;    
    }
    
}