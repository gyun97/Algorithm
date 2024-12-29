import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int left = 1, right = 1;
        int sum = 1;  // 현재 구간 합
        int answerCount = 0;

        while (right <= N) {
            if (sum < N) {
                right++;
                sum += right;  // 구간에 숫자 추가
            } else if (sum > N) {
                sum -= left;  // 구간에서 숫자 제거
                left++;
            } else {
                answerCount++;  // 합이 N과 같을 경우
                sum -= left;  // 현재 left를 제거하고 다음으로 진행
                left++;
            }
        }

        System.out.println(answerCount);
    }
}
