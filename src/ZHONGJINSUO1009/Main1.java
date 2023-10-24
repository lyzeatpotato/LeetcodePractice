package ZHONGJINSUO1009;

import java.util.*;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/9 19:29
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String num1 = in.nextLine();
        String num2 = in.nextLine();
        System.out.println(getSolved(num1, num2));
    }

    public static String getSolved(String num1, String num2) {
        int[] a = new int[num1.length()];
        int[] b = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            a[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            b[i] = num2.charAt(i) - '0';
        }
        int[] result = new int[a.length + b.length];
        //进位
        int carry = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            carry = 0;
            for (int j = b.length - 1; j >= 0; j--) {
                int temp = a[i] * b[j] + carry + result[i + j + 1];
                result[i + j + 1] = temp % 10;
                carry = temp / 10;
            }
            if (carry != 0) {
                result[i] = carry;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
