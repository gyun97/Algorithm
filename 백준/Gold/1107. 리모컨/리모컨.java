import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer> brokenButtons = new ArrayList<>();
        if (M > 0) { // M == 0인 경우 방지
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                brokenButtons.add(Integer.parseInt(st.nextToken()));
            }
        }

        int answer = Math.abs(N - 100); // + , - 만 사용한 경우
        int min = Integer.MAX_VALUE; // 버튼을 최소 몇 번 눌러야 하는지
        int count = 0; // 현재 버튼 누른 횟수

        for (int i = 0; i <= 999999; i++) { // N이 최대 500,000이기 때문에 최대 6자리수인 999,999까지 완전 탐색
            String str = String.valueOf(i); // 해당 수의 각 자릿수 보기 위해 문자열화
            boolean flag = false; // 해당 숫자(i)를 누룰 수 있는지 확인
            for (int j = 0; j < str.length(); j++) {
                if (brokenButtons.contains(str.charAt(j) - '0')) { // 만약 i에 고장난 숫자가 들어간다면 각 자릿수 확인 중단
                    flag = true;
                    break;
                }
            }

            if (flag) continue; // 만약 해당 숫자(i)를 누룰 수 없다면 다음 숫자로 넘어가기

            count = str.length() + Math.abs(N - i); // 현재 버튼 누른 횟수: 현재 숫자 i의 자릿수(숫자키 누른 횟수) + (+, -) 누른 횟수
            min = Math.min(min, count); // 최소 버튼 횟수 갱신
        }

        answer = Math.min(answer, min); // +, - 버튼만 사용한 횟수 vs 숫자키와 +, - 사용한 횟수 중 최솟값
        System.out.println(answer);
        
    }

}




