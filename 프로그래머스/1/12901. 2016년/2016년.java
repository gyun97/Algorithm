        class Solution {
            public String solution(int a, int b) {
                String answer = "";

                String[] yoils = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

                int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

                int month = 0;
                for (int i = 0; i <= a - 2; i++) {
                    month += months[i];
    //                System.out.println(months[i]);


                }
    //            System.out.println(month);
                int days = month + b;
    //            System.out.println(days);

                int yoil = (days - 1) % 7;
                answer += yoils[yoil];


                return answer;
            }
        }