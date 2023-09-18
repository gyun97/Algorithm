import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Double> grade_std = new HashMap<>();

        grade_std.put("A+", 4.5);
        grade_std.put("A0", 4.0);
        grade_std.put("B+", 3.5);
        grade_std.put("B0", 3.0);
        grade_std.put("C+", 2.5);
        grade_std.put("C0", 2.0);
        grade_std.put("D+", 1.5);
        grade_std.put("D0", 1.0);
        grade_std.put("F", 0.0);

        double total_credit = 0;
        double major_grade = 0;


        for (int i = 0; i < 20; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String object = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String str_grade = st.nextToken();

            if (str_grade.equals("P")){
                continue;
            }
            double grade = grade_std.get(str_grade);

                major_grade += credit * grade;
                total_credit += credit;
                
        }
        double answer = major_grade/total_credit;
        String formated_answer = String.format("%.6f",answer);

        sb.append(formated_answer);
        System.out.println(sb);
    }
           }
