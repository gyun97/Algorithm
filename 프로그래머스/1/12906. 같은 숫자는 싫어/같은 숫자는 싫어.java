import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (queue.getLast() != arr[i]) {
                queue.offer(arr[i]);
            }
        }


        int[] answer = queue.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;


    }
}