import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 작업들 요청 시간순으로 오름차순 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        ); 
        
        int time = 0; // 현재 시간
        int idx = 0; // jobs 인덱스
        int total = 0; // 반환 시간의 총합
        int count = 0; // 처리한 작업 수
        
        while (count < jobs.length) {
            
            while (idx < jobs.length && time >= jobs[idx][0]) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                time += job[1];
                total += time - job[0];
                count++;
            } else {
                time = jobs[idx][0];
            }
             
        }
        
        return total / jobs.length;
    }
}