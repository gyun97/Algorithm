import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] prices = new Integer[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            prices[i] = sc.nextInt();
            sum += prices[i];
        }


        Arrays.sort(prices, Collections.reverseOrder());
//        Arrays.stream(prices).forEach(System.out::println);

        int discount = 0;

        for (int j = 2; j < N; j += 3) {
            discount += prices[j];
        }

        int answer = sum - discount;

        System.out.println(answer);
    }
}