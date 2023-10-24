package MIHAYOU0924;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 20:57
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h = scan.nextInt();
        int cnt = 0, k = 0;
        for (int i = 0; i < n; i++) {
            int t = scan.nextInt();
            int x = scan.nextInt();
            if (t == 1) {
                cnt += x;
            } else {
                h -= x;
            }
        }
        if (h <= 0) {
            System.out.println(1);
            return;
        }

        double[] dp = new double[h + 1];
        dp[h] = 1;

        for (int i = 0; i < cnt; i++) {
            double[] g = new double[h + 1];
            for (int j = h; j >= 0; j--) {
                for (int z = 1; z <= 6; z++) {
                    if (j - z <= 0) {
                        g[0] += dp[j] / 6;
                    } else {
                        g[j - z] += dp[j] / 6;
                    }
                }
            }
            dp = g;
        }
        System.out.println(dp[0]);
    }
}
