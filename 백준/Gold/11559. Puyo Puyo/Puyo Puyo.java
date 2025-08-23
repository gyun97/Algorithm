import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static char[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        field = new char[12][6];

        for (int i = 0; i < 12; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 6; j++) {
                field[i][j] = input[j];
            }
        }
        int chainCount = 0;

        while (true) {
            visited = new boolean[12][6];
            List<int[]> toRemove = new ArrayList<>();

            // 모든 칸 탐색
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') {
                        List<int[]> group = bfs(i, j, field[i][j]);

                        if (group.size() >= 4) {
                            toRemove.addAll(group);
                        }
                    }
                }

            }
            // 터질 그룹이 없으면 종료
            if (toRemove.isEmpty()) break;

            // 동시에 터뜨리
            for (int[] pos : toRemove) {
                field[pos[0]][pos[1]] = '.';
            }

            applyGravity();
            chainCount++;
        }

        System.out.println(chainCount);
    }

    // 중력 적용해서 밑으로 떨어뜨리기
    private static void applyGravity() {
        for (int col = 0; col < 6; col++) {
            Queue<Character> q = new LinkedList<>();
            for (int row = 11; row >= 0; row--) {
                if (field[row][col] != '.') {
                    q.add(field[row][col]);
                }
            }

            // 다시 아래부터 채우기
            for (int row = 11; row >= 0; row--) {
                if (!q.isEmpty()) {
                    field[row][col] = q.poll();
                } else {
                    field[row][col] = '.';
                }
            }
        }
    }

    //
    private static List<int[]> bfs(int x, int y, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> group = new ArrayList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        group.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (0 <= nx && nx < 12 && 0 <= ny && ny < 6) {
                    if (!visited[nx][ny] && color == field[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        group.add(new int[]{nx, ny});
                    }
                }

            }

        }
        return group;
    }


}
