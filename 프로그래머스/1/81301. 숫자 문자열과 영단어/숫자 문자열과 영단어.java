import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String s) {

        Map<String, Integer> hm = new HashMap<>();

        hm.put("zero", 0);
        hm.put("one", 1);
        hm.put("two", 2);
        hm.put("three", 3);
        hm.put("four", 4);
        hm.put("five", 5);
        hm.put("six", 6);
        hm.put("seven", 7);
        hm.put("eight", 8);
        hm.put("nine", 9);

        for (String string : hm.keySet()) {
            if (s.contains(string)) {
                s = s.replaceAll(string, String.valueOf(hm.get(string)));
            }
        }
        // System.out.println(s);
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "23four5six7";
        // System.out.println(sol.solution(s));
    }
}