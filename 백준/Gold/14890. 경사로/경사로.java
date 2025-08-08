import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, L, roadCount;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        L = Integer.parseInt(st.nextToken()); // 경사로의 길이
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row < N; row++) {
            if (canPass(map[row])) roadCount++;
        }

        for (int col = 0; col < N; col++) {
            int[] line = new int[N];
            for (int row = 0; row < N; row++) {
                line[row] = map[row][col];
            }
            if (canPass(line)) roadCount++;
        }

        System.out.println(roadCount);


    }

    private static boolean canPass(int[] line) {
        boolean[] used = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int slopeDiff = line[i] - line[i + 1]; // 경사 차이

            // 경사 차이가 없는 경우
            if (slopeDiff == 0) continue;

                // 오르막길인 경우
            else if (slopeDiff == -1) {
                for (int j = 0; j < L; j++) {
                    int idx = i - j;
                    if (idx < 0 || line[idx] != line[i] || used[idx]) return false;
                    used[idx] = true;
                }
            }

            // 내리막길인 경우
            else if (slopeDiff == 1) {
                for (int j = 1; j <= L; j++) {
                    int idx = i + j;
                    if (idx >= N || line[idx] != line[i + 1] || used[idx]) return false;
                    used[idx] = true;
                }
            }
            // 경사 차이가 1이상인 겨우
            else {
                return false;

            }

        }
        return true;

    }

}