import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        ArrayList<Integer> yak_su = new ArrayList<>();

        for (int i = M; i < N+1; i++){
            int count = 0;
            if (i > 1){
                for (int j = 2; j < Math.floor(Math.sqrt(i)) + 1; j++){
                    if (i % j == 0){
                        count =+ 1;
                        break;
                    }

                }
                if (count == 0) {
                    yak_su.add(i);
                    sum += i;
                }
                
            }
        }
        if (yak_su.size() > 0){
            System.out.println(sum);
            System.out.println(Collections.min(yak_su));
        }
        else{
            System.out.println(-1);
        }
        
    }
}