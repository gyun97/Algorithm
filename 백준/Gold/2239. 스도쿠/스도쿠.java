import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int[][] puzzle;
    static List<Point> zeroList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        puzzle = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = str.charAt(j) - '0';
            }
        }

        zeroList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (puzzle[i][j] == 0) {
                    zeroList.add(new Point(i, j));
                }
            }
        }

        // 백트래킹 시작
        sudoku(0);

    }

    // 숫자 num을 (x, y) 좌표에 넣을 수 있는지 확인하는 함수
    private static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (puzzle[x][i] == num || puzzle[i][y] == num) {
                return false;
            }
        }

        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (puzzle[i][j] == num) {
                    return false;
                }
            }
        }

        return true;

    }

    private static void sudoku(int depth) {
        if (depth == zeroList.size()) {
            printPuzzle();
            System.exit(0);
        }

        Point pos = zeroList.get(depth);
        int x = pos.x;
        int y = pos.y;

        for (int num = 1; num <= 9; num++) {
            if (isValid(x, y, num)) {
                puzzle[x][y] = num;
                sudoku(depth + 1);
                puzzle[x][y] = 0; // 되돌리기
            }
        }


    }

    private static void printPuzzle() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(puzzle[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

