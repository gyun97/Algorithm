import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<Integer>[] graph;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        
        graph = new ArrayList[n + 1];
        
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
        
        answer = 0;
        
        visited = new boolean[n + 1];
        
        for (int i = 1; i <= n; i++) {
            bfs(i);
        }
        
    
        
//         visited = new boolean[n + 1][n + 1];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (!visited)
//             }
//         }
        
        return answer;
    }
    
    
    public void bfs(int start) {
        
        if (visited[start]) return;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        answer++;
        
        
        
        
        
        
        
    }
}