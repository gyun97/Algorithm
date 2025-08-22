import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuilder sb1 = new StringBuilder(S);
        StringBuilder sb2 = new StringBuilder(T);


        // DFS로 풀면 2^1000의 시간 복잡도여서 시간 초과
        /* greedy를 이용해서 S -> T로 만드는 것이 아니라
          역으로 T -> S를 만들면 A를 제거하거나 뒤집고 B를 제하는 양자택일, 즉 경우의 수가 1가지뿐이므로  시간복잡도 O(T)*/
        System.out.println(greedy(sb1, sb2));
    }

    private static int greedy(StringBuilder S, StringBuilder T) {

        while (!(S.toString().equals(T.toString()))) {

            // T의 마지막이 A도 아니고 B도 아닌 경우거나 이미 T가 S보다 더 짧아진 경우
            if (S.length() > T.length() || (T.charAt(T.length() - 1) != 'A' && T.charAt(T.length() - 1) != 'B')){
                return 0;
            }

            // T의 마지막이 A인 경우 -> A를 제거한다.
            else if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            }

            // T의 마지막이 B인 경우 -> B를 제거하고 문자열을 뒤집는다.
            else if (T.length() == 0 || T.charAt(T.length() - 1) == 'B') {
                T.deleteCharAt(T.length() - 1).reverse();
            }
        }

        return 1;
    }


}
