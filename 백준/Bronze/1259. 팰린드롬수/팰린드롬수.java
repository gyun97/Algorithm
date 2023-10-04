import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true){
            String num = br.readLine();
            if (num.equals("0")){
                break;
            }
            else{
                sb.append(num);
                String reversed_num = String.valueOf(sb.reverse());
                sb.setLength(0);
                if (reversed_num.equals(num)){
                    System.out.println("yes");
                }
                else{
                    System.out.println("no");
                }
            }
        }

        }
}