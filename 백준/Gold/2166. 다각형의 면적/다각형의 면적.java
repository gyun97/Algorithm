import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }

        double area = 0;


        // 다각형의 넓이를 구하는 대표적인 알고리즘인 신발끈 공식 사용하기
        for (int i = 0; i < N; i++) {
            long x1 = A[i][0];
            long y1 = A[i][1];
            long x2 = A[(i + 1) % N][0];  // 다음 점, 마지막 점일 경우 첫 점
            long y2 = A[(i + 1) % N][1];

            area += (x1 * y2) - (x2 * y1);
        }

        area = (Math.abs(area)) / 2;
        System.out.printf("%.1f", area);

    }
}

