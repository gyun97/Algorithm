import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        int N = sc.nextInt();
        int N = Integer.parseInt(br.readLine());
        int title = 666;
        int count_6 = 0;

        while (true){
            if (Integer.toString(title).contains("666")){
                count_6 += 1;
            }
            if (count_6 == N){
                bw.write(String.valueOf(title));
                break;
            }
            title += 1;
        }
        br.close();

        bw.flush();
        bw.close();
    }
}