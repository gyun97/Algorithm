import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {

        Map<String, LocalTime> hm = new HashMap<>(); // {주차한 차량 번호 : 입차 시간} 담을 해시맵
        Map<String, Long> sum = new HashMap<>(); // {주차장 이용 차량 번호 : 요금} 담을 해시맵


        for (int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
                LocalTime time = LocalTime.of(Integer.parseInt(s[0].substring(0, 2)), Integer.parseInt(s[0].substring(3)));
            if (!hm.containsKey(s[1])) { // IN이라면
                hm.put(s[1], time); // 차랑 번호 : 입차 시간
            } else { // OUT이라면
                Duration duration = Duration.between(hm.get(s[1]), time); // 입차 시간과 출차 시간간의 차이
                sum.put(s[1], sum.getOrDefault(s[1], 0L) + duration.toMinutes()); // 누적 요금 해시맵에 시간차 누적합 반영
                hm.remove(s[1]); // OUT(출차)했으니까 해시맵에서 삭제
            }
        }

        // 입차만 하고 출차하지 않은 차량들 요금 정산
        for (String carNum : hm.keySet()) {
            LocalTime time = LocalTime.of(23, 59);
            Duration duration = Duration.between(hm.get(carNum), time); // 입차 시간과 23:59간의 시간 차이 계산
            sum.put(carNum, sum.getOrDefault(carNum, 0L) + duration.toMinutes()); //누적 요금 해시맵에 시간차 누적합 반영
        }

        List<String> sort = new ArrayList<>(sum.keySet()); // 차량 번호 정렬을 위해 차량 번호를 sort 리스트에 담음
        Collections.sort(sort); // 차량 번호 담은 리스트 정렬

        List<Integer> result = new ArrayList<>(); // 결과 담을 리스트
        
        /*
        fees[0] : 기본 이용 시간
        fees[1] : 기본 요금
        fees[2] : 단위 시간
        fees[3] : 단위 요금
         */

        for (String carNum : sort) { // 차량 번호 오름차순 순서대로 for-each
            if (sum.get(carNum) <= fees[0]) { // 해당 차량의 주차장 총 이용 시간이 기본 시간 이하라면
                result.add(fees[1]); // 기본 요금 부과
            } else { // 해당 차량의 주차장 총 이용 시간이 기본 시간 초과시
                int fee = fees[1] + (int) Math.ceil((double)(sum.get(carNum) - fees[0]) / fees[2]) * fees[3]; // 기본 요금 + (초과 시간 / 단위 시간) 올림 * 단위 요금
                // (double)로 형변환 해주는 이유는 나누기 연산을 하면 소수점 이하가 버려지기 때문에 정확한 계산을 위해 형변환
                result.add(fee); // 결과 리스트에 추가

            }
        }
        return result;
    }
}