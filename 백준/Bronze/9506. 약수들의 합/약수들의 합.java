import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));



        while (true){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            int sum = 0;

            if ( n == -1){
                break;
            }

            for (int i = 1; i < n; i++){
                if (n % i == 0){
                    arr.add(i);
                    sum += i;
                }
            }
            if (sum == n){
                bw.write(Integer.toString(n) + " = ");
                for (int j = 0; j < arr.size(); j++){
                    if (j != arr.size() - 1){
                    bw.write(String.valueOf(arr.get(j) + " + " ));}
                    else{
                        bw.write(String.valueOf(arr.get(j) + "\n"));
                    }
                }
            }
            else{
                bw.write(String.valueOf(n) + " is NOT perfect.\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}