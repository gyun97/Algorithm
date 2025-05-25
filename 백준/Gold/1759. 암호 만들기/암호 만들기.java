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

        String result = "";

        secret(0, 0, result, 0, 0);

    }

    private static boolean isVowel(String s) {
        return "aeiou".contains(s);
    }

    /**
     * 
     * @param depth 문자열 길이
     * @param idx 
     * @param result 문자열
     * @param vCount 모음 개수
     * @param cCount 자음 개수
     */
    private static void secret(int depth, int idx, String result, int vCount, int cCount) {
        if (depth == L) {
            if (vCount >= 1 && cCount >= 2) {
                System.out.println(result);
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (isVowel(A[i])) {
                secret(depth + 1, i + 1, result + A[i], vCount + 1, cCount);
            } else {
                secret(depth + 1, i + 1, result + A[i], vCount, cCount + 1);
            }

        }


    }

}


