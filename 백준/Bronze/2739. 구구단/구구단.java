import java.io.*;
import java.text.Format;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i < 10; i++){
            System.out.println(String.format("%d * %d = %d", N, i, N*i));
        }
    }
}