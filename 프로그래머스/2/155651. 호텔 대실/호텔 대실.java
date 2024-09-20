import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(String[][] book_time) {

        int[][] times = new int[book_time.length][2];
        int result = 1;  // 최소 하나의 방이 필요하므로 1로 초기화

        for (int i = 0; i < book_time.length; i++) {
            String[] using = book_time[i];

            // 시작 시간 계산
            String start = using[0];
            String[] startHourAndMin = start.split(":");
            int startTotalMin = Integer.parseInt(startHourAndMin[0]) * 60 + Integer.parseInt(startHourAndMin[1]);

            // 종료 시간 계산 (10분 청소 시간을 포함)
            String end = using[1];
            String[] endHourAndMin = end.split(":");
            int endTotalMin = Integer.parseInt(endHourAndMin[0]) * 60 + Integer.parseInt(endHourAndMin[1]) + 10;

            // 시작 시간과 종료 시간을 배열에 저장
            times[i][0] = startTotalMin;
            times[i][1] = endTotalMin;
        }

        // 시작 시간을 기준으로 정렬
        Arrays.sort(times, Comparator.comparingInt((int[] a) -> a[0]));

        // 종료 시간을 저장하는 배열
        int[] roomEndTimes = new int[book_time.length];
        roomEndTimes[0] = times[0][1]; // 첫 번째 회의의 종료 시간 저장

        // 모든 예약을 순회
        for (int i = 1; i < times.length; i++) {
            boolean foundRoom = false;

            // 기존 방들의 종료 시간과 현재 시작 시간을 비교
            for (int j = 0; j < result; j++) {
                if (times[i][0] >= roomEndTimes[j]) {
                    // 현재 회의를 이 방에 배정할 수 있으면 종료 시간 업데이트
                    roomEndTimes[j] = times[i][1];
                    foundRoom = true;
                    break;
                }
            }

            // 만약 기존 방에 배정할 수 없다면 새로운 방을 추가
            if (!foundRoom) {
                roomEndTimes[result] = times[i][1];
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(sol.solution(book_time));  // 출력: 3
    }
}
