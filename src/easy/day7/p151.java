package easy.day7;

import java.util.Scanner;

/**
 * @ClassName: p151
 * @Description: 反转字符串中的单词
 * @author: lyz
 * @date: 2023 08 2023/8/2 22:29
 */

public class p151 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        //1.删除多余的空格（收尾空格/中间多余空格）
        String s1 = dropOtherBlanks(s);
        //2.反转整个字符串
        String s2 = reverseByStartEnd(s1, 0, s1.length() - 1);
        //3.反转每个单词
        int start = 0;
        int end;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == ' ') {
                end = i - 1;
                s2 = reverseByStartEnd(s2, start, end);
                start = i + 1;
            }
            if (i == s2.length() - 1) {
                s2 = reverseByStartEnd(s2, start, i);
            }
        }
        return s2;
    }

    public static String dropOtherBlanks(String s) {
        int left = 0;
        int right = s.length() - 1;
        //先找到收尾的非空格字符
        while (s.charAt(left) == ' ') {
            left ++;
        }
        while (s.charAt(right) == ' ') {
            right --;
        }
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char charAt = s.charAt(left);
            if (charAt != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(charAt);
            }
            left ++;
        }
        return sb.toString();
    }

    public static String reverseByStartEnd(String s, int start, int end) {
        int left = start;
        int right = end;
        StringBuffer sb = new StringBuffer(s);
        while (left < right) {
            char temp = sb.charAt(right);
            sb.setCharAt(right, sb.charAt(left));
            sb.setCharAt(left, temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}
