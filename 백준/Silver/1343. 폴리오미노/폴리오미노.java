import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();

        board = board.replaceAll("XXXX", "AAAA");
        board = board.replace("XX", "BB");

        String answer = !board.contains("X") ? board : "-1";
        System.out.println(answer);

    }
}