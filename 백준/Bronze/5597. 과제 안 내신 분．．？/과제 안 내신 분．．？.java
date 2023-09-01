import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            arrayList.add(i);
        }

        for (int j = 1; j <= 28; j++){
            int num = Integer.parseInt(br.readLine());
            if (arrayList.contains(num)){
                arrayList.remove(Integer.valueOf(num));
            }
        }
        for (int k = 0; k < arrayList.size(); k++){
            System.out.println(arrayList.get(k));
        }
        }
    }