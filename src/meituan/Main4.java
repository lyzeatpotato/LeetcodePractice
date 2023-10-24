package meituan;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 19:45
 */

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(deleteElements(a, k, 0, 1));
    }

    public static int deleteElements(int[] a, int k, int index, int lcm) {
        if (k == 0) {
            for (int i = index; i < a.length; i++) {
                if (lcm % a[i] != 0) {
                    return 0;
                }
            }
            return 1;
        }
        int ans = 0;
        for (int i = index; i < a.length; i++) {
            ans += deleteElements(a, k - 1, i + 1, lcm * a[i] / gcd(lcm, a[i]));
        }
        return ans;
    }

    public static int gcd(int x, int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}
