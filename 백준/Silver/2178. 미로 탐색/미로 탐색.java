import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int N, M;
    static int x = 0;
    static int y = 0;
    static int[][] maze;
    static boolean[][] visited;
    static Queue<Point> queue = new LinkedList<>();  // Point 클래스는 2차원 평면상의 한 점을 나타내는 클래스.
                                                     // 좌표 평면상의 한 점의 x와 y 좌표를 저장 가능

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];

        maze = new int[N][M];

        // 미로(이중 배열) 완성
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
//            char[] ch = str.toCharArray();
            for (int j = 0; j < str.length(); j++) {
                maze[i][j] = str.charAt(j) - '0'; // 0의 아스키 코드값인 48을 빼서 char형 숫자 int형으로 변환

            }

        }

        bfsMaze(x, y);  // 메서드 호출하여 bfs 실행
        System.out.println(maze[N-1][M-1]);  // 구하고자 하는 목표인 마지막 칸의 인덱스 값 출력

    }

    public static void bfsMaze(int x, int y) {

         int[] dx = {1, -1, 0, 0};  // 행 1칸 이동(상하)
         int[] dy = {0, 0, 1, -1};  // 열 1칸 이동(좌우)

        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point currentPostion  = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = currentPostion.x + dx[i];
                int ny = currentPostion.y + dy[i];

                if ( (0 <= nx && nx < N) && (0 <= ny && ny < M) && (maze[nx][ny] == 1) && (!visited[nx][ny]) ) {
                    visited[nx][ny]  = true;
                    queue.offer(new Point(nx, ny));
                    maze[nx][ny] = maze[currentPostion.x][currentPostion.y] + 1;  // 현재 칸의 최단 거리 = 이전 칸의 최단거리 + 1
                }
            }
        }

    }
    
}