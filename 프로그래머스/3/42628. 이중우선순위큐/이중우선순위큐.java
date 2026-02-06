import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < operations.length; i++) {
            String order = operations[i];
            
            if (order.charAt(0) == 'I') {
                int n = Integer.parseInt(order.substring(2));
                minHeap.add(n);
                maxHeap.add(n);
                // System.out.println(n);
                
            } else if (order.equals("D -1") && !minHeap.isEmpty()) {
                int min = minHeap.poll();
                maxHeap.remove(min);
            } else if (order.equals("D 1") && !maxHeap.isEmpty()) {
                int max = maxHeap.poll();
                minHeap.remove(max);
            }
            
            
        }
        
        if (minHeap.isEmpty() && maxHeap.isEmpty()) return new int[]{0, 0};
        
        int min = minHeap.poll();
        int max = maxHeap.poll();
        
        return new int[]{max, min};
        
        
    }
}