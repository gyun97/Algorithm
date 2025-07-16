import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solutions = new int[N];

        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        int start = 0;
        int end = N - 1;
        int minAbs = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (start < end) { // 두 포인터가 교차하기 전까지 반복 (두 용액을 섞기 위한 조건)
            int sum = solutions[start] + solutions[end]; // 현재 두 용액의 특성값 합 계산

            if (Math.abs(sum) < minAbs) { // 지금까지의 합 중 절댓값이 최소인지 확인
                minAbs = Math.abs(sum);   // 최소 절댓값 갱신
                ans1 = solutions[start];  // 현재 조합 저장
                ans2 = solutions[end];
            }

            if (sum < 0) {
                start++; // 합이 음수 → 더 큰 값 필요 → 왼쪽 포인터 오른쪽으로 이동
            } else {
                end--;   // 합이 양수 또는 0 → 더 작은 값 필요 → 오른쪽 포인터 왼쪽으로 이동
            }
        }

        System.out.println(ans1 + " " + ans2);

    }
}
