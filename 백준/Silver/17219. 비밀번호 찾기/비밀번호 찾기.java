import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> hashMap = new HashMap<>();

        while (N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            hashMap.put(st.nextToken(), st.nextToken());
        }

        while (M --> 0) {
            String find = br.readLine();
            sb.append(hashMap.get(find)).append("\n");
        }

        System.out.println(sb);
        
    }

}