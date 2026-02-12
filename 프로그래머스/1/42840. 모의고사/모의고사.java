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





import java.util.*;

class Solution {
    public static int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] hit = new int[3];
        for(int i = 0; i < hit.length; i++) {
            for(int j = 0; j < answers.length; j++) {
                if(patterns[i][j % patterns[i].length] == answers[j]) hit[i]++;
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < hit.length; i++)
            if(max == hit[i]) list.add(i + 1);

        int[] answer = new int[list.size()];
        int cnt = 0;
        for(int num : list)
            answer[cnt++] = num;
        return answer;
    }
}
