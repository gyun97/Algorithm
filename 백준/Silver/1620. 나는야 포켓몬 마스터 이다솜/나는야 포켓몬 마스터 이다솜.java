import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> keyString = new HashMap<>();
        HashMap<Integer, String> keyInteger = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            keyString.put(name, i);
            keyInteger.put(i, name);
        }

        while (M --> 0) {
            String questions = br.readLine();
            boolean checkInteger = Character.isDigit(questions.charAt(0));  // Character.isDigit: 첫 글자가 0 ~ 9이면 true
            if (checkInteger) {
                int questionsIndex = Integer.parseInt(questions) - 1;
                String s = keyInteger.get(questionsIndex);
                sb.append(s).append("\n");
            } else {
                Integer i = keyString.get(questions);
                sb.append(i + 1).append("\n");
            }
        }

        System.out.println(sb);


    }
}