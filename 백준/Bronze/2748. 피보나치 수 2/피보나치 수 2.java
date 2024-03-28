import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

    static long[] table;
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        table = new long[91];
        table[0] = 0;
        table[1] = 1;
        table[2] = 1;

        System.out.println(fibo(n));
        
    }

    public static long fibo(int n) {
        for (int i = 3; i < n + 1; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];

    }

}