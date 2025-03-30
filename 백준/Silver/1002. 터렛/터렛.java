import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(tangentPoint(x1, y1, r1, x2, y2, r2)).append("\n");
        }
        System.out.println(sb);


    }

    private static int tangentPoint(int x1, int y1, int r1, int x2, int y2, int r2) {

        /* (x1, y1)와 (x2, y2) 사이의 거리는 ( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½ 이다.
          double dis = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y2, 2));
          하지만 double, float형은 부소수점 타입이어서 근사치로 나오기 때문에 오차 때문에 == 비교 힘들다.
          따라서 Math.sprt()로 루트 형태로 쓰지 말고 제곱되어 있는 형태인 (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)²을 사용하자.
          int dis = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
         */


        // 조규현과 백승환의 사이의 거리(두 점 사이의 거리)
        int dis = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        /* 1. 두 원의 접점의 개수가 무한대일 때 => 두 원이 완전히 겹침*/
        if (x1 == x2 && y2 == y1 && r1 == r2) return -1;


            /* 2. 두 원의 접점의 개수가 0일 때 => 두 원이 만나지 X */

            // 2 - 1. 두 원이 서로 완전히 떨어져 있다 -> 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때 => ( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  > 𝑟₁ + 𝑟₂ => (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)²  > (𝑟₁ + 𝑟₂)²
        else if (dis > Math.pow(r1 + r2, 2)) return 0;

            // 2- 2. 한 원 안에 겹치지 않는 다른 원이 있다  -> 반지름의 차가 두 원간의 중점 거리보다 크다 => ( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  <  ∣𝑟₂ - 𝑟₁∣ => (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)²  <  (𝑟₂ - 𝑟₁)²
        else if (dis < Math.pow(r1 - r2, 2)) return 0;


            /* 3. 두 원의 접점의 개수가 1일 때 => 두 원이 한 점에서 만난다*/

            // 3 - 1. 두 원이 외접한다 -> 반지름의 합이 두 원간의 중점 거리와 같다 => ( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  =  𝑟₂ + 𝑟₁ =>  (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)²  =  (𝑟₂ + 𝑟₁)²
        else if (dis == Math.pow(r2 + r1, 2)) return 1;

            // 3- - 2. 두 원이 내접한다 -> 두 반지름의 차가 두 좌표간의 차랑 같 => ( (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)² )½  =  ∣𝑟₂ - 𝑟₁∣ => (𝑥₂ - 𝑥₁)² + (𝑦₂ - 𝑦₁)²  =  (𝑟₂ - 𝑟₁)²
        else if (dis == Math.pow(r2 - r1, 2)) return 1;


            /* 4. 두 원의 접점의 개수가 2일 때 => 두 원이 두 점에서 만난다.*/
        else return 2;
    }


}

