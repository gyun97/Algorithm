import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String str_N = String.valueOf(N);
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for (int i = 0; i < N; i++){
            String str_i = String.valueOf(i);
            for (int j = 0; j < str_i.length(); j++){
                sum += Character.getNumericValue(str_i.charAt(j));
            }
        if (N - sum == i){
            arr.add(i);
        }
        else{
            sum = 0;
        }
        }
        if (arr.size() >= 1){
            int min_value = Collections.min(arr);
            sb.append(min_value);

        }
        else{
            sb.append(0);
        }
        System.out.println(sb);

    }
}