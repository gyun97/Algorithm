import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

class Solution {
    public int solution(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k =  j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
//                    System.out.printf("%d +_%d + %d = %d\n", nums[i], nums[j], nums[k], sum);
                    int half = (int) Math.sqrt(sum);
                    boolean isPrime = true;
                    for (int l = 2; l <= half; l++) {
                        if (sum % l == 0) {
                            isPrime = false;
                            break;
                        }

                    }
                    if (isPrime) count++;

                }

            }
        }
//        System.out.println(count);
        return count;



    }


//    public static void main(String[] args) {
//        Solution sol1 = new Solution();
//        int[] nums1 = {1, 2, 3, 4};
//        sol1.solution(nums1);

//        Solution sol2 = new Solution();
//        int[] nums2 = {1, 2, 7, 6, 4};
//        sol2.solution(nums2);
//     }



}