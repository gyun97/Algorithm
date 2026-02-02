import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> q = new ArrayDeque<>();
        q.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != q.peekLast()) q.add(arr[i]);
        }
        
        // System.out.println(q);
    
        
        int[] answer = new int[q.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
            // System.out.println(answer[i]);
        }

        return answer;
    }
}