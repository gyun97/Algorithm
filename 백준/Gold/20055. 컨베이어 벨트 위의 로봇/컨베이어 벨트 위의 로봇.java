import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] A;          // 내구도
    static boolean[] robot;  // 로봇 위치 (위쪽 N칸만 필요)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        robot = new boolean[N]; // 올리는 위치~내리는 위치까지만 필요

        int step = 0;
        while (true) {
            step++;

            rotate();      // 1. 벨트와 로봇 회전
            moveRobots();  // 2. 로봇 이동
            putRobot();    // 3. 로봇 올리기

            if (countZero() >= K) break; // 4. 종료 조건
        }

        System.out.println(step);
    }

    // 벨트 회전
    private static void rotate() {
        // 내구도 회전
        int last = A[2 * N - 1];
        for (int i = 2 * N - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = last;

        // 로봇 회전
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;

        // 내리는 위치에 도달한 로봇은 내림
        robot[N - 1] = false;
    }

    // 로봇 이동
    private static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && A[i + 1] > 0) {
                robot[i] = false;
                A[i + 1]--; // 이동한 칸 내구도 감소
                if (i + 1 != N - 1) {
                    robot[i + 1] = true; // 내리는 위치가 아니면 로봇 옮김
                }
            }
        }
        // 내리는 위치 로봇 제거
        robot[N - 1] = false;
    }

    // 로봇 올리기
    private static void putRobot() {
        if (A[0] > 0 && !robot[0]) {
            robot[0] = true;
            A[0]--;
        }
    }

    // 내구도 0 개수 세기
    private static int countZero() {
        int cnt = 0;
        for (int durability : A) {
            if (durability == 0) cnt++;
        }
        return cnt;
    }
}
