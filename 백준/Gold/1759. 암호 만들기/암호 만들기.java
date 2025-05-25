import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int L, C;
    static String[] A;
//    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();

        A = new String[C];

        for (int i = 0; i < C; i++) {
            String s = sc.next();
            A[i] = s;
        }

        Arrays.sort(A);
//        System.out.println(Arrays.toString(A));

        secret(0, 0, "", 0, 0);


    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    /**
     * 
     * @param length 문자열 길이
     * @param idx 시작 인덱스
     * @param result 현재 문자열
     * @param vowelCount 현재 모음 개수
     * @param consonantCount 현재 자음 개수
     */
    private static void secret(int length, int idx, String result, int vowelCount, int consonantCount) {

        if (length == L) {
            if (vowelCount >= 1 && consonantCount >= 2) {
                System.out.println(result);
            }
            return;
        }

        for (int i = idx; i < A.length; i++) {
            if (isVowel(A[i].charAt(0))) {
                secret(length + 1, i + 1, result + A[i], vowelCount + 1, consonantCount);
            } else {
                secret(length + 1, i + 1, result + A[i], vowelCount , consonantCount + 1);
            }

        }


    }


}




