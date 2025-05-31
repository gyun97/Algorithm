import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<String> stack = new ArrayDeque<>();

        String[] sticks = br.readLine().split("");

        int answer = 0;
        boolean flag = false;

        for (int i = 0; i < sticks.length; i++) {

            String s = sticks[i];

            if (sticks[i].equals("(")) {
                flag = false;
                stack.push("(");
                answer++;

            } else {
                // 레이저인 경우
                if (flag == false) {
                    flag = true;
                    stack.pop();
                    answer--;
                    answer += stack.size();
                } else {
                    stack.pop();
                }


            }
        }

        System.out.println(answer);



    }
}
