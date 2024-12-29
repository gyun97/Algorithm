import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num  = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arr = str.split("");

        int sum = 0;

        for (int i = 0; i < num; i++){
            int s = Integer.parseInt(arr[i]);
            sum += s;
        }
        br.close();
        sb.append(sum);
        System.out.println(sb);
    }
}