import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] paper;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = new int[3];

        partition(0, 0, N);

        for (int i : answer) {
            System.out.println(i);
        }

    }

    // 해당 영역이 같은 색인지 검사하는 메소드
    private static boolean isSameColor(int row, int col, int size) {
        int first = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (first != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void partition(int row, int col, int size) {
        if (isSameColor(row, col, size)) {
            if (paper[row][col] == -1) {
                answer[0]++;
            } else if (paper[row][col] == 0) {
                answer[1]++;
            } else {
                answer[2]++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + newSize * 2, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + newSize * 2, newSize);

        partition(row + newSize * 2, col, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);

    }
}



