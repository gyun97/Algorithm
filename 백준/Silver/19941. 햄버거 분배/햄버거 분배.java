import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        ArrayList<Character> HPlist = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char ch = input.charAt(i);
            HPlist.add(ch);
        }

        int count = 0;

//        Arrays.stream(HPlist).forEach(i -> System.out.print(i));

        for (int i = 0; i < N; i++) {
            if (HPlist.get(i).equals('P')) {
                int start = Math.max(0, i - K);
                int end = Math.min(N, i + K + 1);
                for (int j = start; j < end; j++) {
                    if (HPlist.get(j).equals('H')) {
                        count++;
                        HPlist.set(j, 'X');
                        break;
                    }

                }

            }

        }
        sb.append(count);
        System.out.println(sb);


    }
}