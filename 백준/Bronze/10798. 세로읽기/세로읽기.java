import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       String[] letters = new String[5];

       for (int i = 0; i < 5; i++){
          letters[i] = br.readLine();
       }

       for (int i = 0; i < 15; i++){
           for (int j = 0; j < 5; j++){
               try{
                   char s = letters[j].charAt(i);
                   bw.write(s);
               }
               catch (IndexOutOfBoundsException I){
                   continue;
               }
           }
       }
       br.close();
       bw.flush();
       bw.close();
    }

}