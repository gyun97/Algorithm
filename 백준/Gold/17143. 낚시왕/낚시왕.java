import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
    int r;
    int c;
    int s; // 속력
    int d; // 방향
    int z; // 크기

    public Shark(int r, int c, int s, int d, int z) {
        this.r = r;
        this.c = c;
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class Main {

    static int R, C, M;
    static Shark[][] board;
    static int[] dx = {-1, 1, 0, 0}; // 위, 아래
    static int[] dy = {0, 0, 1, -1}; // 오른쪽, 왼쪽

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        M = Integer.parseInt(st.nextToken()); // 상어의 수

        board = new Shark[R + 1][C + 1]; // (0, 0)이 낚시꾼 처음 위치

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); // 상어 위치 행
            int c = Integer.parseInt(st.nextToken()); // 상어 위치 열
            int s = Integer.parseInt(st.nextToken()); // 상어의 속력
            int d = Integer.parseInt(st.nextToken()) - 1; // 상어의 이동 방향 (1: 위, 2: 아래, 3: 오른쪽, 4: 왼쪽)
            int z = Integer.parseInt(st.nextToken()); // 상어의 크기

            board[r][c] = new Shark(r, c, s, d, z);
        }

        int sum = 0;
        for (int c = 1; c <= C; c++) {
            for (int r = 1; r <= R; r++) {
                Shark curShark = board[r][c];
                if (curShark != null) {
                    sum += curShark.z;
                    board[r][c] = null;
                    break;
                }
            }
            moving();
        }

        System.out.println(sum);
    }

    private static void moving() {
        Shark[][] temp = new Shark[R + 1][C + 1];

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {

                if (board[r][c] != null) {
                    Shark curShark = board[r][c];
                    int sharkSpeed = curShark.s;
                    int sharkDir = curShark.d;
                    int nr = r, nc = c;

                    if (sharkDir == 0 || sharkDir == 1) { // 위, 아래
                        sharkSpeed %= (R - 1) * 2;
                    } else { // 오른쪽, 왼쪽
                        sharkSpeed %= (C - 1) * 2;
                    }

                    for (int i = 0; i < sharkSpeed; i++) {

                        nr += dx[sharkDir];
                        nc += dy[sharkDir];
                        if ((0 < nr && nr <= R) && (0 < nc && nc <= C)) {
                            continue;
                        } else {
                            // 원래 자리로 복귀
                            nr -= dx[sharkDir];
                            nc -= dy[sharkDir];

                            switch (sharkDir) {
                                case 0:
                                    sharkDir = 1;
                                    nr += dx[sharkDir];
                                    nc += dy[sharkDir];
                                    break;
                                case 1:
                                    sharkDir = 0;
                                    nr += dx[sharkDir];
                                    nc += dy[sharkDir];
                                    break;
                                case 2:
                                    sharkDir = 3;
                                    nr += dx[sharkDir];
                                    nc += dy[sharkDir];
                                    break;
                                case 3:
                                    sharkDir = 2;
                                    nr += dx[sharkDir];
                                    nc += dy[sharkDir];
                                    break;
                            }
                        }
                    }

                    curShark.r = nr;
                    curShark.c = nc;
                    curShark.d = sharkDir;

                    if (temp[nr][nc] == null) { // 현재 칸에 상어 없다면 현재 상어 이주
                        temp[nr][nc] = curShark;
                    } else {
                        Shark existingShark = temp[nr][nc];
                        if (existingShark.z < curShark.z) { // 같은 칸에 있는 기존 상어보다 현재 상어가 더 크면 현재 상어가 잡아먹음
                            temp[nr][nc] = curShark;
                        }
                    }
                }

            }
        }

        board = temp;
    }
}
