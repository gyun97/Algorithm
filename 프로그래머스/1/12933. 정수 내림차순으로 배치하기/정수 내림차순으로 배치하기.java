import java.util.Arrays;
import java.util.Collections;

class Solution {
    public long solution(long n) {

        long answer = 0;
        String[] strings = String.valueOf(n).split("");
        Arrays.sort(strings, Collections.reverseOrder());
        long[] array = Arrays.stream(strings).mapToLong(Long::parseLong).toArray();
        
        int idx = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            answer += array[idx] * Math.pow(10, i);
            idx++;

        }
        return answer;


    }
}