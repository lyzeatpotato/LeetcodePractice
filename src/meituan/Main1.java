package meituan;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 19:50
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        boolean flag = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) {
                flag = false;
                break;
            }
        }
        int pre = a[1] - a[0];
        for (int i = 2; i < a.length; i++) {
            int cur = a[i] - a[i - 1];
            if (cur >= pre) {
                flag = false;
                break;
            }
            pre = cur;
        }
        System.out.println(flag ? "YES" : "NO");
    }
}
