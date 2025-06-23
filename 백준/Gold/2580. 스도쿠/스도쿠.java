import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);


        // 결과 출력
        for (int[] row : map) {
            for (int n : row) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);


    }

    private static boolean sudoku(int row, int col) {
        if (col == 9) return sudoku(row + 1, 0); // 다음 줄로 이동
        if (row == 9) return true; // 끝까지 성공

        if (map[row][col] != 0) return sudoku(row, col + 1); // 빈 칸이 아닌 경우 옆 칸으로 이동

        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                map[row][col] = num;

                if (sudoku(row, col + 1)) return true;

                map[row][col] = 0;

            }
        }
        return false;

    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[row][i] == num || map[i][col] == num) return false; // 같은 행 또는 열에 같은 숫자 있으면 false

        }

        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }

}





