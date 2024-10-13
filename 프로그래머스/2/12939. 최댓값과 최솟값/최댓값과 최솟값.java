import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] result = new String[3];
        Integer min = Arrays.stream(s.split(" ")).map(Integer::parseInt).min(Integer::compare).get();
        Integer max = Arrays.stream(s.split(" ")).map(Integer::parseInt).max(Integer::compare).get();

        result[0] = String.valueOf(min);
        result[1] = " ";
        result[2] = String.valueOf(max);

        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}