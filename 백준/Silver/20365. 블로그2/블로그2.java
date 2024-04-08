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

        colorCount.replace(input.charAt(0), 1);

        for (int i = 1; i < N; i++) {
            char current = input.charAt(i);
            if (current != input.charAt(i - 1)) {
                colorCount.replace(current, colorCount.get(current) + 1);
            }
        }

        int answer = Math.min(colorCount.get('B'), colorCount.get('R')) + 1;
        sb.append(answer);
        System.out.println(answer);

    }
}