import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k); // 우선순위 큐의 초기 용량을 k로 설정
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]); // 새로운 점수를 큐에 추가
            
            // k개가 넘는 경우 최소값을 제거
            if (pq.size() > k) {
                pq.poll();
            }
            
            answer[i] = pq.peek(); // 현재 k번째 큰 값을 저장
        }

        return answer;
    }
}