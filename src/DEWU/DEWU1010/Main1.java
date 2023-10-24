package DEWU.DEWU1010;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/10 10:21
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        String s = in.next();
        System.out.println(isBeautiful(s, x));
    }

    public static int isBeautiful(String s, int x) {
        int n = s.length();
        for (int i = 0; i < n - x; i++) {
            if (s.charAt(i) == s.charAt(i + x - 1)) {
                String substring = s.substring(i, i + x);
                StringBuilder sb = new StringBuilder(substring);
                String s1 = sb.reverse().toString();
                if (substring.equals(s1)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
