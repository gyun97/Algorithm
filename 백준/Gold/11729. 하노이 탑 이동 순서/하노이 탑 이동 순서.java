import java.io.IOException;
import java.util.Scanner;


public class Main {

    static int K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 원판의 개수
        K = 0; // 옮긴 횟수
        hanoi(N, 1, 3, 2);

        System.out.println(K);
        System.out.println(sb);


    }

    /*
    1. 위에 있는 N-1개의 원판을 보조 장대(2번)로 옮긴다.
    2. 가장 큰 원판(맨 아래 원판)을 목표 장대(3번)로 옮긴다.
    3. 보조 장대(2번)에 있는 N-1개의 원판을 목표 장대(3번)로 옮긴다.

    이 과정을 재귀적으로 반복.
     */

    private static void hanoi(int N, int from, int to, int via) {
        K++;
        if (N == 1) {
//            System.out.println(from + " " + to);
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(N - 1, from, via, to); // 1. 위에 있는 N-1개의 원판을 보조 장대(2번)로 옮긴다.
        sb.append(from + " " + to + "\n"); // 2. 가장 큰 원판(맨 아래 원판)을 목표 장대(3번)로 옮긴다.
        hanoi(N - 1, via, to, from);


    }

}
