import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> directionMap = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directionMap.put(time, dir);
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<Point> snake = new ArrayDeque<>(); // 뱀 몸(꼬리, 머리 포함)이 위치한 좌표 저장
        snake.add(new Point(0, 0)); // 처음 좌표 (0, 0)

        boolean[][] snakeBody = new boolean[N][N]; // 뱀 몸이 위치한 좌표 표시
        snakeBody[0][0] = true; // 처음 몸 위치 (0, 0)

        int x = 0, y = 0; // 처음 좌표 (0, 0)
        int time = 0; // 처음 시간 0초
        int dir = 1; // 처음 방향(dir) 오른쪽
        /*
        d = 0 : 위 / d = 1 : 오른쪽 / d = 2 : 아래쪽 / d = 3 : 왼쪽
         */

        while (true) {
            time++; // 한 번 반복할 때마다 시간 + 1

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (0 > nx || nx >= N || 0 > ny || ny >= N) break; // 벽에 부딪힘
            if (snakeBody[nx][ny]) break; // 자기 몸에 부딪힘

            // 이동
            if (board[nx][ny] == 1) { // 이동한 자리에 사과가 있다면
                board[nx][ny] = 0; // 사과 먹음
                snake.addLast(new Point(nx, ny)); // 사과 있던 곳 좌표 뱀 몸 추가
                snakeBody[nx][ny] = true;// 사과 있던 곳 좌표 뱀 몸 표시
            } else { // 이동한 자리에 사과가 없다면
                snake.add(new Point(nx, ny));
                snakeBody[nx][ny] = true;
                Point tail = snake.pollFirst(); // 꼬리(가장 처음 들어간 몸) 제거
                snakeBody[tail.x][tail.y] = false; // 꼬리(가장 처음 들어간 몸) 표시 원상복구
            }

            x = nx;
            y = ny;

            if (directionMap.containsKey(time)) { // 방향 전환해야 하는 시간이라면
                char turn = directionMap.get(time);
                if (turn == 'D') { // 오른쪽으로 방향 전환해야 한다면
                    dir = (dir + 1) % 4; // 오른쪽으로 방향 전환
                } else { // 왼쪽으로 방향 전환해야 한다면
                    dir = (dir + 3) % 4; // 왼쪽으로 방향 전환
                }
            }

        }
        System.out.println(time);

    }
}


