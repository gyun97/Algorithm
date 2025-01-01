import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.next().split("");
        int[] nums = new int[strings.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[maxIdx] < nums[j]) {
                    maxIdx = j;
                }
            }
            if (nums[i] < nums[maxIdx]) {
                int temp = nums[i];
                nums[i] = nums[maxIdx];
                nums[maxIdx] = temp;
            }
        }

        for (int num : nums) {
            System.out.print(num);
        }

    }
}
