import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = IntStream.rangeClosed(1, N).toArray();

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            while ( left < right){
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        for (int z = 0; z < arr.length; z++){
            System.out.print(arr[z] + " ");
        }
        br.close();
    }
        }
