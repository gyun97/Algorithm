import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] classRoom;
    static int[] students;
    static Map<Integer, List<Integer>> favorites;
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classRoom = new int[N][N];
        students = new int[N * N];
        favorites = new HashMap<>();

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            students[i] = student;

            List<Integer> preferences = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                preferences.add(Integer.parseInt(st.nextToken()));
            }

            favorites.put(student, preferences);
        }

        for (int student : students) {
            placeStudent(student);
        }

        System.out.println(calculateSatisfication());


    }

    private static void placeStudent(int student) {
        List<int[]> candidates = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                int emptyCount = 0, likeCount = 0;

                // 이미 다른 사람이 앉아있는 경우
                if (classRoom[x][y] != 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    // 범위 안이면
                    if (isInbound(nx, ny)) {
                        if (classRoom[nx][ny] == 0) emptyCount++; // 인접한 칸이 0이면
                        else if (favorites.get(student).contains(classRoom[nx][ny])) likeCount++; // 인접한 칸에 좋아하는 친구가 있다면
                    }
                }

                candidates.add(new int[]{likeCount, emptyCount, x, y});
            }
        }
        candidates.sort((a, b) -> {
            /*
            자리 후보들 정렬 우선순위
             */
                    if (a[0] != b[0]) return b[0] - a[0]; // 1. 좋아하는 친구가 많은 자리
                    if (a[1] != b[1]) return b[1] - a[1]; // 2. 인접한 빈칸이 많은 자리
                    if (a[2] != b[2]) return a[2] - b[2]; // 3. 행의 번호가 작은 자리
                    return a[3] - b[3]; // 4. 열의 번호가 작은 자
                }
        );

        int[] chosen = candidates.get(0);
        classRoom[chosen[2]][chosen[3]] = student;
    }


    private static boolean isInbound(int nx, int ny) {
        return (0 <= nx && nx < N) && (0 <= ny && ny < N);
    }


    private static int calculateSatisfication() {
        int totalSum = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int count = 0;
                int student = classRoom[x][y];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (isInbound(nx, ny)) {
                        if (favorites.get(student).contains(classRoom[nx][ny])) count++;
                    }
                }
                if (count > 0) totalSum += Math.pow(10, count - 1);

            }

        }
        return totalSum;

    }
}