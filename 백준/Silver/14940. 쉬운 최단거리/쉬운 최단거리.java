import org.w3c.dom.ls.LSOutput;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Main {

    public static int n, m;  // n : 세로, m, : 가로
    public static int[][] map, visited, dis;
    public static Queue<Point> queue;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];
        dis = new int[n][m];


//        for (int i = 0; i < n; i++) {
//            map[i] = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray(); // 지도를 작성


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for (int i = 0; i < n; i++) {
////            Arrays.fill(visited[i], 0);
////        }
////
////        for (int i = 0; i < n; i++) {
////            Arrays.fill(dis[i], 0);
////        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    bfs(i, j);
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && dis[i][j] == 0) {
                    dis[i][j] = -1;
                }
            }
        }

        for (int[] row : dis) {
            Arrays.stream(row).forEach(i -> sb.append(i + " "));
            sb.append("\n");

        }
        System.out.println(sb);



//        for (int i = 0; i < n; i++) {
//
//            for (int j = 0; j < m; j++) {
//
////                System.out.print(dis[i][j]);
//                System.out.println();
//            }
//        }
    }


    public static void bfs(int x, int y) {
        queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = 1;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            for (int i = 0; i < 4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];
                if ((0 <= nx && nx < n) && (0 <= ny && ny < m) && (visited[nx][ny] == 0) && (map[nx][ny] == 1)) {
//                 if (0 > nx || nx >= n) continue;
//                 if (0 > ny || ny >= m) continue;
//                 if (visited[nx][ny] == 1) continue;
//                 if (map[nx][ny] == 0) continue;
                    visited[nx][ny] = 1;
                    dis[nx][ny] = dis[currentPoint.x][currentPoint.y] + 1;
                    queue.add(new Point(nx, ny));
                }

            }

        }

    }

}