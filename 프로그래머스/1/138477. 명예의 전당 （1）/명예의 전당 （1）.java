import java.util.PriorityQueue;

/**
 * K일까지는 발표되는 모든 점수가 명예의 전당에 들고
 * K + 1일부터는 명예의 전당의 최하위 점수는 명예의 전당에서 밀려나고
 * 매일 명예의 전당의 최하위 점수는 answer 배열에 담아 반환해야 된다.
 *
 *
 */
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] answer = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                pq.add(score[i]);
            }
            
            if (i >= k && pq.peek() < score[i]) {
                pq.poll();
                pq.add(score[i]);
            }
            answer[i] = pq.peek();

        }
        return answer;
    }
}
