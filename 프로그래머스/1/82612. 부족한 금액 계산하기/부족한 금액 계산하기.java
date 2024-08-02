class Solution {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long spend = 0;
        
        for (int i = 1; i <= count; i++){
            spend += i * price;
        }
        return (spend - money > 0) ? spend - money : 0;

        
    }
}