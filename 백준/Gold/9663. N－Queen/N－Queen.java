import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N, count;
    static int[] col;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        count = 0;
        col = new int[N];
        nQueen(0);
        sb.append(count);
        System.out.println(sb);

    }

    private static void nQueen(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i; // row 행의 i 열에 퀸을 놓음
            if (isSafe(row)) {
                nQueen(row + 1);
            }
        }


    }

    private static boolean isSafe(int row) {
        /*
    왜 i < row까지만 확인하나?

    row는 지금 퀸을 놓으려는 행.

    i는 이미 퀸을 배치한 이전 행들.

    우리는 항상 한 행씩 순서대로 퀸을 놓기 때문에,

    0행 → 1행 → 2행 → ... 이런 식으로만 놓여 있음.

    즉, col[0], col[1], ..., col[row - 1]까지는 퀸이 이미 배치됨.

    반면, col[row]은 지금 시험적으로 놓아보는 위치.

    그래서, 현재 놓으려는 퀸(row)이 기존 퀸들과 충돌하는지만 보면 돼.

         */
        for (int i = 0; i < row; i++) {
            if (col[row] == col[i]) return false; // 같은 열
            if (Math.abs(col[row] - col[i]) == row - i) return false; // 같은 대각선 (열의 차와 행의 차가 같을 경우가 대각선에 놓여있는 경우다)
        }
        return true;
    }




}


