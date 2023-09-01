import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] dices = {A, B, C};
        int prize_money = 0;

        if (A != B && B != C && A!=C){
            prize_money = (Math.max(C, Math.max(A, B))) * 100;
        }
        else{
            if (A == B && B ==C){
                prize_money = 10000 + A * 1000;
            }
            else{
                if (A == B){
                    prize_money = 1000 + A * 100;
                }
                else if (B == C){
                    prize_money = 1000 + C * 100;
                }
                else if (A == C){
                    prize_money = 1000 + C * 100;
                }
            }
        }
        System.out.println(prize_money);
    }
}
