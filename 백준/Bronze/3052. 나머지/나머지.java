import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> num_arrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            if (!num_arrayList.contains(num%42)){
                num_arrayList.add(num%42);
            }
        }
        sb.append(num_arrayList.size());
        System.out.println(sb);

        }
    }
