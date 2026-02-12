// import java.util.*;

// class Solution {
//     public int[] solution(int[] answers) {
        
//         List<Integer>[] list = new List[4];
        
//         list[1] = Arrays.asList(1, 2, 3, 4, 5);
//         list[2] = Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5);
//         list[3] = Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5);
        
//         System.out.println(Arrays.toString(list));
        
//         int[] result = new int[4];
        
//         for (int i = 0; i < answers.length; i++) {
//             for (int j = 1; j < 4; j++) {
//                 int idx = i % list[j].size();
//                 if (answers[i] == list[j].get(idx)) {
//                     result[j]++;
//                 }
//             }
//         }
        
//         // System.out.println(Arrays.toString(result));
        
//         int max = Arrays.stream(result).max().getAsInt();
//         // System.out.println(max);
        
//         List<Integer> answer = new ArrayList<>();
        
//         for (int i = 1; i < result.length; i++) {
//             if (max == result[i]) answer.add(i);
//         }
        
//         Collections.sort(answer);
    
//         return answer.stream().mapToInt(i -> i).toArray();
//     }
// }



import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}