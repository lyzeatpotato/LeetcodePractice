package meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 19:07
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int num : a) {
            max = Math.max(max, num);
        }
        int count = 0;
        while (a[0] < max) {
            a[0] *= 2;
            count++;
        }
        for (int num : a) {
            while (num > a[0]) {
                num /= 2;
                count++;
            }
        }
        System.out.println(count);
    }
}
