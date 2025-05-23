import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int size = (int) Math.pow(2, N);

        Z(r, c, size);
        System.out.println(count);
        
    }

    private static void Z(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int half = size / 2;

        // 1사분면
        if (r < half && c < half) {
            Z(r, c, half);

        // 2사분면
        } else if (r < half && c >= half) {
            count += size * size / 4;
            Z(r, c - half, half);

        // 3사분면
        } else if (r >= half && c < half) {
            count += (size * size / 4) * 2;
            Z(r - half, c, half);

        // 4사분면
        } else {
            count += (size * size / 4) * 3;
            Z(r - half, c - half, half);
        }






    }
}


