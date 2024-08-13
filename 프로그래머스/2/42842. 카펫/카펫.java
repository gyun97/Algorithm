class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = new int[2];

        double root = Math.sqrt(yellow);
        int a = 0;
        int b = 0;

        for (int i = 1; i <= root; i++) {
            if (yellow % i == 0) {
                a = i;
                b = yellow / i;
            }
            if ((a + b) * 2 + 4 == brown) {
                answer[0] = Math.max(a, b) + 2;
                answer[1] = Math.min(a, b) + 2;
            }

        }
        
        return answer;
    }
}


