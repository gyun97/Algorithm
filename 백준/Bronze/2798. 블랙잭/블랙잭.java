import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> cards = new ArrayList<>();
        ArrayList<Integer> card_sums = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");

        while (st.hasMoreTokens()){
            cards.add(Integer.parseInt(st.nextToken()));
        }

        int sum = 0;

        for (int i = 0; i < N-2; i++){
            for (int j = i+1; j < N-1; j++){
                for (int k = j+1; k < N; k++){
                    sum = cards.get(i) + cards.get(j) + cards.get(k);
                    if (sum <= M){
                        card_sums.add(sum);
                    }
                }
            }
        }

        int max_sum = Collections.max(card_sums);
        sb.append(max_sum);
        System.out.println(sb);
    }
}