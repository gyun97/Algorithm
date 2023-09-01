import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        String[] element_list = input.split(" ");
        int[] elements = new int[N];

        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(element_list[i]);
        }
        for (int element : elements){
            if (element == v){
                count += 1;
            }

        }
        System.out.println(count);
    }
}