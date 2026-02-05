import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int sum = 0;
        
        for (Integer s : scoville) {
            sum += s;
            pq.offer(s);
        }
        
        if (sum == 0) return -1;
            
        while (pq.size() >= 2) {
            int first = pq.poll(); 
            if (first >= K) return answer;
    
            answer++;
            
            int second = pq.poll();
            int newFood = first + (second * 2);
            
            
            pq.offer(newFood);
        }
        
        if (pq.poll() < K) return -1;
        
        return answer;
        
    }
}