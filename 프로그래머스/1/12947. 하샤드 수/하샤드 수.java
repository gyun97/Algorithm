class Solution {
    public boolean solution(int x) {
            String [] tmp = String.valueOf(x).split("");
            int sum=0;
            for(String s:tmp) {
                sum+=Integer.parseInt(s);
            }

        return x % sum == 0;
        }

    public static void main(String[] args) {

        // 테스트 케이스 1
        int x = 18; // 18은 각 자릿수 합이 9이고, 18 % 9 == 0
        Solution sol = new Solution();

        boolean result = sol.solution(x);
        System.out.println("테스트 값: " + x + ", 결과: " + result);

    }

    }

