import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] A;
    static boolean[] robot;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 컨테이어 벨트의 길이
        K = Integer.parseInt(st.nextToken()); // 내구도가 0인 칸의 한계 개수

        A = new int[2 * N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        robot = new boolean[N]; // 내리는 위치 때문에 아래에 위치한 벨트 절반은 신경 안 써도 됨

        /*
        1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
        2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
        1. 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
        3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
        4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다
         */

        int count = 0; // 몇 번째 과정(사이클)인지

        while (true) {
            count++;
            rotationBelt(); // 벨트 회전
            robotMoving(); // 로봇 한 칸 이동
            putRobot(); // 올리는 위치의 칸의 내구도가 0이 아니라면 로봇 올리기
            if (countZero() >= K) { // 내구도가 0인 칸의 개수 세기
                break;
            }
        }
        System.out.println(count);
    }

    // 내구도가 0인 칸이 몇 개인지 세는 메서드
    private static int countZero() {
        int countZero = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) countZero++;
        }
        return countZero;
    }

    // 올리는 위치에 로봇을 올리는 경우
    private static void putRobot() {
        if (A[0] > 0 && !robot[0]) {
            robot[0] = true;
            A[0]--; // 로봇 올린 칸 내구도 - 1
        }

    }

    // 로봇이 한 칸씩 옆으로 이동하는 경우 처리
    private static void robotMoving() {
        for (int i = N - 2; i >= 0; i--) {
            if (robot[i] && !robot[i + 1] && A[i + 1] > 0) {
                robot[i] = false;
                if (i + 1 != N - 1) { // 내리는 위치가 아니라면
                    robot[i + 1] = true;
                }
                A[i + 1]--;
            }
        }

        // 내리는 위치 로봇 내리기
        if (robot[N - 1]) robot[N - 1] = false;
    }

    // 컨테이어 벨트 회전 처리(벨트 회전으로 인한 로봇 이동, 로봇 하차도 포함)
    private static void rotationBelt() {
        int last = A[A.length - 1];
        for (int i = A.length - 1; i > 0; i--) {
            A[i] = A[i - 1];
        }
        A[0] = last;

        // 로봇 회전
        for (int i = N - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;

        // 내리는 위치 로봇 내리기 (빠져있던 부분!)
        if (robot[N - 1]) robot[N - 1] = false;
    }

}
