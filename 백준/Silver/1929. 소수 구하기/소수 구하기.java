import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] arr = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;

            for (int j = i + i; j <= N; j += i) {
                arr[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (arr[i] != 0) System.out.println(arr[i]);
        }
//        Arrays.stream(arr).filter(i -> i >= M).filter(i -> i != 0).forEach(System.out::println);

    }


}





