/* 
체육복 잃어버린 학생들 순서대로 순회하면서 -> 앞의 학생이 여벌이 있는지 -> 뒤의 학생이 여벌이 있는지 -> 둘 다 없으면 lostCount++ ->
마지막에 n - lostCount
*/

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    answer++;
                    break;
                }           
            }
        } 
        
        for (int i : lost) {
            
            // if (i == -1) continue;
            
            int front = i - 1;
            int back = i + 1;
            
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == front || reserve[j] == back) {
                    reserve[j] = -1;
                    answer++;
                    break;
                }
    
            }    
        }
        
        return answer;
    }
}