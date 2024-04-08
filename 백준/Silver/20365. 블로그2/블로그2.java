import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String input = br.readLine();

        HashMap<Character, Integer> colorCount = new HashMap<>();

        colorCount.put('B', 0);
        colorCount.put('R', 0);

        colorCount.replace(input.charAt(0), 1);  // 첫번째 색깔은 무조건 칠해야함

        for (int i = 1; i < N; i++) {  // 현재 색깔과 이전 색깔이 다르면 칠해야함
            char current = input.charAt(i);  // 현재 색깔
            if (current != input.charAt(i - 1)) {  // 이전 색깔과 다르면 칠해야함
                colorCount.replace(current, colorCount.get(current) + 1);  // 칠함
            }
        }

        int answer = Math.min(colorCount.get('B'), colorCount.get('R')) + 1;    // 더 작은 색깔의 수 + 1(더 많은 색깔로 전체 칠함
        sb.append(answer);
        System.out.println(answer);

    }
}