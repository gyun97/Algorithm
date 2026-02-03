import java.util.*;

class Truck {
    int weight;
    int pos;
    
    public Truck(int weight) {
        this.weight = weight;
        this.pos = 1;
    }
    
    public void moving() {
        pos++;
    }
    
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Truck> bridge = new LinkedList<>(); // 다리
        Queue<Truck> wait = new LinkedList<>(); // 트럭대기열
        
        for (int w : truck_weights) {
            wait.offer(new Truck(w));
        }
        
        int time = 0; // 최소 경과 시간(정답)
        int curW = 0; // 현재 다리 위의 트럭 무게 총합
        
        // 다리와 대기열에 트럭 전부 없애질 때까지(모든 트럭이 다리를 건널 때까지) 반복
        while (!bridge.isEmpty() || !wait.isEmpty()) {
            
            time++; // 1초 추가 경과
            
            // 만약 아직 다리에 트럭이 없다면
            if (bridge.isEmpty()) {
                Truck curT = wait.poll();
                bridge.offer(curT);
                curW += curT.weight;
                continue;
            }
            
            // 다리 위 모든 트럭들 한칸씩 전진
            for (Truck t : bridge) t.moving();
            
            // 만약 가장 앞에 있는 트럭이 다리를 지났다면
            if (bridge.peek().pos > bridge_length) {
                Truck firstTruck = bridge.poll(); 
                curW -= firstTruck.weight;
            }
            

            // 대기열 트럭이 남아있고 무게 초과되지 않아 대기열의 트럭을 다리에 올릴 수 있다면
            if (!wait.isEmpty() && curW + wait.peek().weight <= weight) {
                Truck curT = wait.poll();
                bridge.offer(curT);
                curW += curT.weight;
            }
            
        }
        
        return time;
        
        
        
        
    }
}