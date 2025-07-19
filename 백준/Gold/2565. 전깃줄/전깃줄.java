import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] lines = new int[N][2];

        for (int i = 0; i < N; i++) {
            lines[i][0] = sc.nextInt(); // A
            lines[i][1] = sc.nextInt(); // B
        }

        // A 기준 정렬
        Arrays.sort(lines, Comparator.comparingInt(a -> a[0]));

        // B 값만 뽑아서 LIS
        int[] dp = new int[N];
        int length = 0;

        for (int i = 0; i < N; i++) {
            int b = lines[i][1];
            int idx = Arrays.binarySearch(dp, 0, length, b);
            if (idx < 0) idx = -(idx + 1);
            dp[idx] = b;
            if (idx == length) length++;
        }

        System.out.println(N - length);
    }
}
