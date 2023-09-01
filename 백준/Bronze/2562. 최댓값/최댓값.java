import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[9];

        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        int index = 0;
        for (int j = 1; j < 9; j++){
            if (arr[j] > max){
                max = arr[j];
                index = j;
            }
        }
        sb.append(max + "\n").append(index+1);
        System.out.println(sb);
    }
}