import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else { // c == ')'
                stack.pop(); // 일단 '(' 제거

                if (input.charAt(i - 1) == '(') {
                    // 레이저: 바로 앞이 '('인 경우
                    result += stack.size(); // 현재 열린 막대기 수만큼 잘림
                } else {
                    // 쇠막대기 끝
                    result += 1; // 끝나는 막대기 1조각 추가
                }
            }
        }

        System.out.println(result);
    }
}
