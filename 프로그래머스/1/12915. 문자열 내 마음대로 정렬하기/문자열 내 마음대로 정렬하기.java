import java.util.*;


class Solution {
    public String[] solution(String[] strings, int n) {

        Map<Character, List<String>> treeMap = new TreeMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            Character c = strings[i].charAt(n);
            String s = strings[i];

            treeMap.putIfAbsent(c, new ArrayList<>());
            treeMap.get(c).add(s);

        }

        for (Character c : treeMap.keySet()) {
            List<String> stringList = treeMap.get(c);
            Collections.sort(stringList);

            result.addAll(stringList);
        }

        return result.toArray(new String[0]);

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        System.out.println(Arrays.toString(sol.solution(strings, 1)));
    }
}