import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {

        int max = Arrays.stream(citations).max().getAsInt();
        int h = Math.min(citations.length, max);


        if (h == 0) return h;

        System.out.println(h);
        LOOP:
        while (h > 0) {
            System.out.println(h);
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