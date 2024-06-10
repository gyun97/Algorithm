import java.util.*;

class Solution {
    public int solution(int[][] sizes) {

        List<Integer> maxes = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();


        for (int[] size : sizes) {
            maxes.add(Math.max(size[0], size[1]));
            mins.add(Math.min(size[0], size[1]));
        }

        int max = Collections.max(maxes);
        int min = Collections.max(mins);
        
        return min * max;

    }
}