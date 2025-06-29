import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        String bomb = br.readLine();

        for (int i = 0; i < input.length; i++) {
            sb.append(input[i]);
            if (sb.length() >= bomb.length()) {
                // 끝부분만 잘라서 폭발 문자열과 비교
                if (sb.substring(sb.length() - bomb.length()).equals(bomb)) { // 끝부분이 폭발 문자열과 같다면
                    sb.delete(sb.length() - bomb.length(), sb.length()); // 폭발
                }
            }

        }

        System.out.println(sb.length() == 0 ? sb.append("FRULA") : sb);

    }
}
