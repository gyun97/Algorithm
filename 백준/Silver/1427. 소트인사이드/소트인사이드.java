import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        Integer[] arr = new Integer[N.length()];

        for (int i = 0; i < N.length(); i++){
            arr[i] = Character.getNumericValue(N.charAt(i));
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int num : arr){
            System.out.print(num);
        }
    }
}