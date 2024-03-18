import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, count;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                count = 0;
                if (map[i][j] == 1) {
                    dfs(i, j);
                    result.add(count);

                }

            }
        }

        Collections.sort(result);
        System.out.println(result.size());
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
        result.forEach(System.out::println);
//        result.stream().forEach(System.out::println);

    }

    private static void dfs(int x, int y) {
        map[x][y] = 0;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }


    }


}
