import java.util.*;

class Solution {

    static List<Integer>[] graph;
    static int answer = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }

        System.out.println(Arrays.toString(graph));

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            boolean[] visited = new boolean[n + 1];

            int count = dfs(1, visited);
            graph[a].add(b);
            graph[b].add(a);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }


        return answer;
    }

    public int dfs(int node, boolean[] visited) {
        int count = 1; // 지금 탐색하는 노드 자기 자신
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }

        return count;

    }

}