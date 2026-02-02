import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> q = new ArrayDeque<>(); // 작업들의 완료까지 남은 시간 계산한 큐
        int[] completionDay = new int[progresses.length]; // 작업들의 완료까지 남은 시간 계산한 배열
        
        for (int i = 0; i < progresses.length; i++) {
            // 각 작업들의 완료까지까지 남은 일수 계산
            if ((100 - progresses[i]) % speeds[i] == 0) q.add((100 - progresses[i]) / speeds[i]); 
            else q.add(((100 - progresses[i]) / speeds[i]) + 1); 
        }
        
        // System.out.println(q);
        
        List<Integer> result = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int count = 1;
            
            while (!q.isEmpty() && cur >= q.peek()) {
                count++;
                q.poll();
            }
            
            result.add(count);
        }
        

        
        return result.stream().mapToInt(i -> i).toArray();
    }
}