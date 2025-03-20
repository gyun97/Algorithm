import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] count;
    
    public int solution(int n, int[][] edge) {
        
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // System.out.println("graph = " + Arrays.deepToString(graph));
        
        bfs(1);
        // System.out.println("count = " + Arrays.toString(count));
        
        int maxCnt = 0;
        
        for (int i : count) {
            maxCnt = Math.max(maxCnt, i);
        }
        
        int answer = 0;
        for (int i : count) {
            if (maxCnt == i) {
                answer += 1;
            }
        }
        return answer;
    }
    
    public void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(1);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    count[next] = count[cur] + 1;
                    visited[next] = true;
                    q.offer(next);
                }
                
            }
        }
        
        
    }
}