import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total_price = Integer.parseInt(br.readLine());
        int total_quantity = Integer.parseInt(br.readLine());
        int price_count = 0;

        for (int i = 0; i < total_quantity; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int price = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());
            price_count += price * quantity;
        }

        if (price_count == total_price){
            bw.write("Yes");
        }
        else{
            bw.write("No");
        }
        bw.flush();
        bw.close();
    }
}