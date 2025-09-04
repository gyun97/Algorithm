import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static String[][] map;
    static List<int[]> blanks;
    static List<int[]> teachers;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        blanks = new ArrayList<>();
        teachers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken();
                if (map[i][j].equals("X")) blanks.add(new int[]{i, j});
                if (map[i][j].equals("T")) teachers.add(new int[]{i, j});
            }

        }

        if (dfs(0, 0)) System.out.println("YES");
        else System.out.println("NO");
    }


    private static boolean dfs(int idx, int count) {
        if (count == 3) {
            if (check()) return true;
            return false;
        }

        if (idx >= blanks.size()) return false;

        int[] pos = blanks.get(idx);
        map[pos[0]][pos[1]] = "O";
        if (dfs(idx + 1, count + 1)) return true;

        map[pos[0]][pos[1]] = "X";
        if (dfs(idx + 1, count)) return true;

        return false;
    }

    private static boolean check() {
        for (int[] teacher : teachers) {

            for (int d = 0; d < 4; d++) {
                int nx = teacher[0];
                int ny = teacher[1];
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                    if (map[nx][ny].equals("O")) break;
                    if (map[nx][ny].equals("S")) return false;
                }
            }

        }
        return true;
    }
}
