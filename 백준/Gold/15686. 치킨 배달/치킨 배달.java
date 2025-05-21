import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[][] map;
    static List<Point> chickens;
    static List<Point> homes;
    static boolean[] opend;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(map));

        chickens = new ArrayList<>();
        homes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    chickens.add(new Point(i, j));
                } else if (map[i][j] == 1) {
                    homes.add(new Point(i, j));
                }
            }
        }
        answer = Integer.MAX_VALUE;
        opend = new boolean[chickens.size()];

        dfs(0, 0);
        bw.write(answer + "\n");
        bw.close();

    }

    private static void dfs(int start, int count) {
        if (count == M) {
            int result = 0;

            for (int i = 0; i < homes.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (opend[j]) {
                        int dist = Math.abs(homes.get(i).x - chickens.get(j).x) + Math.abs(homes.get(i).y - chickens.get(j).y);
                        temp = Math.min(temp, dist);
                    }
                }
                result += temp;
            }
            answer = Math.min(answer, result);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            opend[i] = true;
            dfs(i + 1, count + 1);
            opend[i] = false;
        }

    }

}


