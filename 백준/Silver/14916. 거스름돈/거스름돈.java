import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int charge = sc.nextInt();
        int coinCount = 0;

        if (charge != 1 && charge != 3) {
            if ((charge % 5) % 2 != 0) {
                coinCount = (charge / 5) - 1;

            } else {
                coinCount += charge / 5;

            }
            charge = charge - (coinCount * 5);
            coinCount += charge / 2;
            System.out.println(coinCount);
        } else {
            System.out.println(-1);
        }
        
    }
}