import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] ropes = new int[N];
        ArrayList<Integer> results = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(ropes);

        for (int rope : ropes) {
            int result = rope * N;
            results.add(result);
            N--;
        }

        int answer = results.parallelStream().max(Integer::compareTo).get();
        System.out.println(answer);


    }

}