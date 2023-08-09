package easy.day7;

import java.util.Scanner;

/**
 * @ClassName: p344
 * @Description: 反转字符串
 * @author: lyz
 * @date: 2023 08 2023/8/2 14:54
 */

public class p344 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputChar = scan.nextLine();
        char[] s = new char[inputChar.length()];
        for (int i = 0; i < s.length; i++) {
            s[i] = inputChar.charAt(i);
        }
        reverseString(s);
    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left ++;
            right--;
        }
    }
}
