class Solution {
    public int[] solution(int brown, int yellow) {
        
        int width = 0;
        int height = 0;
        
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0) continue;
            
            width = i; // 가로
            height = yellow / i; // 세로
            
            if (width < height) continue;
            
            int brownTemp = ((width + 2) * 2) + (height * 2);
            if (brown == brownTemp) break;
            
        }
        
        return new int[]{width + 2, height + 2};
        
        
    }
}