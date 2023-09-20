import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
//        Collections.sort(arr);  # Collections.sort는 ArrayList에서 사용, 배열에서는 Arrays.sort 사용
        Arrays.sort(arr);  

        for (int num : arr){
            System.out.println(num);
        }
    }
}