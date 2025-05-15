import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        boolean[] visited = new boolean[n + 1];
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
            
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(1);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    dist[next] = dist[cur] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
        int max = Arrays.stream(dist).max().getAsInt();
        int answer = 0;
        for (int i : dist) {
            if (i == max) answer++;
        }
        
        // System.out.println(Arrays.deepToString(graph));
        // System.out.println(Arrays.toString(dist));
    
        return answer;
    }
    
    
    
}