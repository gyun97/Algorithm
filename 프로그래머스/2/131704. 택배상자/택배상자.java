import java.util.Stack;

class Solution {
    public int solution(int[] order) {

        Stack<Integer> sub = new Stack<>();
        int count = 0;
        int idx = 0;

        for (int i = 1; i <= order.length; i++) {
            sub.push(i);
            while (!sub.isEmpty()) {
                if (sub.peek() == order[idx]) {
                    sub.pop();
                    idx++;
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
        

    }
}