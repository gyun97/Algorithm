import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while (N-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int big = Math.max(A, B);
            int small = Math.min(A, B);
            int result = 1;
            // 유클리드 호제법 사용
            while (true) {
                result = big % small;
                big = small;
                small = result;

                if (result == 0) {
                    break;
                }
            }
            System.out.println(big * (A / big) * (B / big));
        }


    }
}





