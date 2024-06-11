import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public int[] solution(int[] answers) {

        int[] person1 = {1, 2, 3, 4, 5};
        int[] person2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == person1[i % person1.length]) scores[0]++;
            if (answers[i] == person2[i % person2.length]) scores[1]++;
            if (answers[i] == person3[i % person3.length]) scores[2]++;
            
        }

//        int maxScore = Math.max(scores[1], Math.max(scores[2], scores[3]));
        int maxScore = Arrays.stream(scores).max().getAsInt();

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
        
    }

}