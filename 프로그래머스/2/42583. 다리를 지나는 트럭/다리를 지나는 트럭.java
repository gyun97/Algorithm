import java.util.LinkedList;
import java.util.Queue;

/**
 * 경우 1. 다리에 아무것도 없는 경우 -> 맨 앞 트럭을 다리에 올리고 시간을 + 1 추가하고 트럭 무게를 다리에 추가
 * <p>
 * 경우 2. 다리 위에 트럭이 있지만 꽉 차지는 않은 경우
 * 2 - 1. 무게 합이 기준보다 낮아 다음 트럭을 올리는 있는 경우 -> 다음 트럭을 다리에 올려 시간 +1, 무게 합 +
 * 2 - 2. 무게 합이 기준보다 높아 다음 트럭을 못 올리는 경우 -> 다리에 0을 추가하여 다리 위 트럭을 앞으로 보내고 시간 + 1
 * <p>
 * 경우 3. 다리가 꽉 찬 경우 -> 가장 앞에 있는 트럭을 다리 밖으로 꺼낸다. 시간 추가는 X
 */

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>();
        int weight_sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                if (bridge.isEmpty()) { // 다리가 비어 있는 경우
                    bridge.add(truck);
                    weight_sum += truck;
                    time++;

                    break;
                } else if (bridge.size() != bridge_length) { // 다리가 비어있지는 않지만 꽉 차지는 않은 경우
                    if (weight_sum + truck <= weight) {
                        bridge.add(truck);
                        weight_sum += truck;
                        time++;
                        break;
                    } else {
                        bridge.add(0);
                        time++;
                    }
                } else { // 다리가 꽉 차있는 경우
                    weight_sum -= bridge.poll();
                }
            }
            // System.out.println("다리 상태: " + bridge);


        }
        return time + bridge_length;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        // System.out.println(sol.solution(bridge_length, weight, truck_weights));
    }
}