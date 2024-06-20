import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



class Point3D{  // 3차원 좌표 클래스
    int z, x, y;

    public Point3D(int z, int x, int y) {
        this.z = z;  // H 대응값. 상자 층 수
        this.x = x;  // N 대응값. 상자 세로
        this.y = y;  // M 대응값. 상자 가로
    }
}


public class Main {

    static StringBuilder sb = new StringBuilder(); // StringBuilder에 출력값 저장

    static int M, N, H;
    static int[][][] tomato;  // 토마토 상자(3차원 배열)

    static Queue<Point3D> queue = new LinkedList<>();
    static int[] dz = {1, -1, 0, 0, 0, 0};  // 상자 1층씩  위아래 이동
    static int[] dx = {0, 0, 1, -1, 0, 0};  // 상자 칸 상하(세로) 한 칸씩 이동
    static int[] dy = {0, 0, 0, 0, 1, -1};  // 상자 칸 좌우(가로) 한 칸씩 이동

    static int day;  // 각 칸의 토마토가 익는 데 걸리는 최소 날짜(에 + 1 되어 있음)


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);  // 가로
        N = Integer.parseInt(input[1]);  // 세로
        H = Integer.parseInt(input[2]);  // 위아래
        tomato = new int[H][N][M];

        // 입력값 받아 3차원 배열 생성
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomato[i][j][k] == 1) queue.add(new Point3D(i, j, k));  // 이미 익은 토마토들 위치 큐에 추가
                }
                }
        }

        bfs(); // BFS 시작
        checkResult();


        // 첫 날에 값이 1인 토마토(익은 토마토)에서 시작했는데 첫 날은 day = 0이기 때문에 최소 날짜보다 1 더 잡힘
        // (각 토마토의 값은 익는데 걸린 최소 날짜)
        sb.append(day - 1);
        System.out.println(sb); // 출력


    }

    // 토마토가 모두 익지 못하는 상황 조건 처리 메서드
    private static void checkResult() {
        //        LOOP:
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) {
                        sb.append(-1);
                        System.out.println(sb);
                        System.exit(0);  // 바로 프로그램(JVM) 정상 종료 처리
//                        break LOOP; -> TIP: 반복문 여러 개 겹쳐 있으면 가장 바깥 반복문에 라벨링하면 break 조건으로 중첩 반복문 바로 탈출 가능
                    } else {
                        day = Math.max(day, tomato[i][j][k]);  // 토마토가 모두 익을 때까지의 최소 날짜니까 비교하면서 익는 데 가장 오래 걸린 토마토 찾아야 한다.
                    }
                }
            }

        }
    }

    // BFS 메서드
    private static void bfs() {
        while (!queue.isEmpty()) {  // 큐가 빌 때까지
            Point3D current = queue.poll();  // 큐에서 토마토 꺼내기
            for (int i = 0; i < 6; i++) {
                int nz = current.z + dz[i];  // 위아래(층)로 이동
                int nx = current.x + dx[i];  // 상하로 이동
                int ny = current.y + dy[i];  // 좌우로 이동
                if (0 > nz || nz >= H || 0 > nx || nx >= N || 0 > ny || ny >= M) continue;  // 범위 밖이면 무시
                if (tomato[nz][nx][ny] == 0) {  // 아직 안 익은 토마토면
                    tomato[nz][nx][ny] = tomato[current.z][current.x][current.y] + 1; // 익는 데 영향 준 인접한 토마토보다 하루 더 걸림
                    queue.add(new Point3D(nz, nx, ny));  // 주변 다른 토마토들에게도 연쇄 영향 주기 위해 큐에 추가 
                }
            }
        }
    }


}