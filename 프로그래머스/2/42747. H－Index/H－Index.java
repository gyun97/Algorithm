import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {

//        int max = Arrays.stream(citations).max().getAsInt();
//        int h = Math.min(citations.length, max);  // h의 최대값은 논문의 수

        int h = citations.length;

        if (h == 0) return h; // [0, 0, 0, ...]

        LOOP:
        while (h > 0) {
            int count = 0;
            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                }
            }
            if (count >= h) {
                break LOOP;
            }
            h--;
        }
        return h;

    }
}
