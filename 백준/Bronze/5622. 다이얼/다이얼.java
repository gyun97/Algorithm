import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] alphaet_list = {"ABC", "DEF", "GHI", "JKL", "MON", "PQRS", "TUV", "WXYZ"};
        String input = br.readLine();

        char[] input_char = input.toCharArray();
        int total_time = 0;

        for (char c : input_char) {
            for (String s : alphaet_list){
                if (s.contains(String.valueOf(c))){
                    total_time += 2 + Arrays.asList(alphaet_list).indexOf(s) + 1;
//                    Arrays.asList(arr).indexOf("b")
                }
            }
        }
        sb.append(total_time);
        System.out.println(sb);
    }
           }

