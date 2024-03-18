import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N;   // 지도의 크기: N * N
    static int[][] graph;   // 지도
    static int[] dx = {1, -1, 0, 0};  // 상하
    static int[] dy = {0, 0, 1, -1};  // 좌우
    static int count;   // 단지 내 집의 수


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];


        ArrayList<Integer> result = new ArrayList<>();   // 단지 내 집의 수를 저장할 리스트

        // 지도 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                graph[i][j] = ch - '0';

            }
        }

        // 지도 모든 인덱스 돌면서 1이면 dfs 수행하고 결과를 result에 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (graph[i][j] == 1) {
                    dfs(i, j);
                    result.add(count);

                }
            }
        }

        Collections.sort(result);
        

        System.out.println(result.size());  // 단지 수 출력
        for (int i = 0; i < result.size(); i++) {   // 단지 내 집의 수 출력
            System.out.println(result.get(i));
        }
    }

    public static void dfs(int x, int y) {   // dfs 수행
        graph[x][y] = 0;    // 방문했다고 표시하고
        count++;    // 단지 내 집의 수를 1 증가시키고


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];     // 상하좌우로 이동하면서
            int ny = y + dy[i];
            if ( (0 <= nx && nx < N) && (0 <= ny && ny < N) && (graph[nx][ny] == 1)) {   // 지도를 벗어나지 않고, 아직 방문하지 않은 집이 있으면
                dfs(nx, ny);    // 재귀적으로 dfs 수행
            }
        }

    }
}
