import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       ArrayList<Integer> arr_x = new ArrayList<>();
        ArrayList<Integer> arr_y = new ArrayList<>();
        int last_x = 0;
        int last_y = 0;

       for (int i = 0; i < 3; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           int x = Integer.parseInt(st.nextToken());
           arr_x.add(x);
           int y = Integer.parseInt(st.nextToken());
           arr_y.add(y);

       }
       for (int j = 0; j<3; j++){
           if (Collections.frequency(arr_x, arr_x.get(j)) == 1){
               last_x = arr_x.get(j);
//               sb.append(last_x).append("\t");
           }

           if (Collections.frequency(arr_y, arr_y.get(j)) == 1){
               last_y = arr_y.get(j);
//               sb.append(last_y);
           }
       }
        System.out.printf("%d %d", last_x, last_y);
    }
}