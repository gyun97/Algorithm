import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            int count = 1;
            ArrayList<String> list = new ArrayList<>();
            HashMap<String, Integer> hashMap = new HashMap<>();
            ArrayList<String> checked = new ArrayList<>();
            while (n --> 0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String cloth = st.nextToken();
                String kind = st.nextToken();
                list.add(kind);
            }

            for (String s : list) {
                if (checked.contains(s)) {
                    continue;
                } else {
                    checked.add(s);
                    int counter = Collections.frequency(list, s);
                    hashMap.put(s, counter);
                }


            }
//            hashMap.forEach((key, value) -> System.out.println(key + ": " + value));
            for (String s : hashMap.keySet()) {
                count *= (hashMap.get(s) + 1);
            }
            
            sb.append(count - 1).append("\n");
        }
        System.out.println(sb);
    }


}