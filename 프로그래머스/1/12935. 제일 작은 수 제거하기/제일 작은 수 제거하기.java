import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {

        int min = Arrays.stream(arr).min().getAsInt();
        return arr.length > 1 ? Arrays.stream(arr).filter(i -> i != min).toArray() : new int[]{-1};


    }
}