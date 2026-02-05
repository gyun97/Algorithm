import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Stack<Integer> stack = new Stack<>(); // 주식 가격이 유지되고 있는 과거 시점들
        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            // 가격이 떨어지는 순간
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }
            
            stack.push(i);    
        }
        
        // 주식 가격이 끝까지 안 떨어진 시점들이 있는 경우
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = (prices.length - 1) - idx;
        }
        
        return answer;
    }
}