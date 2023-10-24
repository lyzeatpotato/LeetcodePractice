package easy.day37;

import java.util.Scanner;

/**
 * @ClassName: p738
 * @Description: 单调递增的数字
 * @author: lyz
 * @date: 2023 08 2023/8/31 9:46
 */

public class p738 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int result = monotoneIncreasingDigits(n);
        System.out.println(result);
    }

    public static int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
