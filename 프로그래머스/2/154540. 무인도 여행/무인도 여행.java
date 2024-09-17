import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Solution {

    static int n;
    static int m;
    static boolean[][] visited;
    static char[][] graph;
    static int sum;
    static List<Integer> result;

    public int[] solution(String[] maps) {

        n = maps.length; // 세로
        m = maps[0].length(); // 가로
        visited = new boolean[n][m];
        graph = new char[n][m];
        result = new ArrayList<>();  // 리스트 초기화

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
            }
        }

        // 각 좌표에서 BFS 수행
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isDigit(graph[i][j]) && !visited[i][j]) { // 숫자이고 방문하지 않은 경우에만 BFS 수행
                    sum = 0;
                    bfs(i, j);
                    result.add(sum); // BFS 끝난 후 합계를 result에 추가
                }
            }
        }

        // 결과를 정렬
        Collections.sort(result);

        // result 리스트가 비어 있으면 [-1] 반환
        if (result.isEmpty()) {
            return new int[]{-1};
        }

        // 리스트를 배열로 변환하여 반환
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void bfs(int x, int y) {

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        sum += Character.getNumericValue(graph[x][y]); // 현재 좌표의 숫자를 합산

        int[] dx = {1, -1, 0, 0}; // 상하 이동
        int[] dy = {0, 0, 1, -1}; // 좌우 이동

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + dx[i];
                int ny = curPoint.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || !Character.isDigit(graph[nx][ny])) {
                    continue;
                }

                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;
                sum += Character.getNumericValue(graph[nx][ny]); // 숫자값을 sum에 더함
            }
        }
    }


}