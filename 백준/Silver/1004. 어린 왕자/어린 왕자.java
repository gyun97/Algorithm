import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        while (T-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int x1 = Integer.parseInt(input1[0]);
            int y1 = Integer.parseInt(input1[1]);
            int x2 = Integer.parseInt(input1[2]);
            int y2 = Integer.parseInt(input1[3]);

            int N = sc.nextInt();
            sc.nextLine(); // 개행 문자 제거

            int count = 0;

            for (int i = 0; i < N; i++) {
                String[] input2 = sc.nextLine().split(" ");
                int cx = Integer.parseInt(input2[0]);
                int cy = Integer.parseInt(input2[1]);
                int r = Integer.parseInt(input2[2]);

                // 출발점과 도착점의 거리 제곱
                int dist1 = (x1 - cx) * (x1 - cx) + (y1 - cy) * (y1 - cy);
                int dist2 = (x2 - cx) * (x2 - cx) + (y2 - cy) * (y2 - cy);
                int rSquared = r * r;

                // 출발점과 도착점이 각각 행성 내부/외부인지 확인
                boolean startInside = dist1 < rSquared;
                boolean endInside = dist2 < rSquared;

                // 한 점만 내부에 있는 경우 카운트 증가
                if (startInside != endInside) {
                    count++;
                }
            }

            System.out.println(count);
        }
        sc.close();
    }
}
