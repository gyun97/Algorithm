import java.util.*;

class Solution {
    
    static boolean[] visited;
    static List<List<Integer>> graph;
    static int[] dist;
    
    public int solution(int n, int[][] edge) {
        
        graph = new ArrayList<>();
        visited = new boolean[n + 1];
        
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        dist = new int[n + 1];
    
        int max = bfs(1);
        
        // System.out.println(Arrays.toString(dist));
        // graph.stream().forEach(i -> System.out.println(i));
        
        int answer = 0;
        
        for (int i : dist) {
            if (i == max) answer++;
        }
        
        return answer;
            
    }
    
    public int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        q.offer(start);
        
        int max = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                    
                    if (dist[next] > 0) {
                        max = dist[next];
                    }
                    
                }
            }
        }
        return max;
    }
    
}