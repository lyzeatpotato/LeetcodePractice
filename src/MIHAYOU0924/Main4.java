package MIHAYOU0924;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 21:04
 */

public class Main4 {

    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
        }
        System.out.println(getMaxCut(a));
    }

    public static int getMaxCut(int[] a) {
        long s1 = 0;
        long s2 = 0;
        int ans = 0;
        for (int i = 1; i <= a.length - 1; i++) {
            ans = (ans += a[i] * s2 % mod) % mod;
            s1 = (s1 + a[i]) % mod;
            s2 = (s2 + s1) % mod;
        }
        return ans;
    }
}
