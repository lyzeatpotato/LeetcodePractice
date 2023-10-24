package QUNAER1013;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/13 16:19
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(getPossibility(n, a, b));
    }

    public static double getPossibility(int n, int a, int b) {
        if (b - a > n) {
            return 1.0;
        }
        double diff = b - a;
        int len = a - 1 + n;
        double[] dp = new double[len];
        dp[0] = 1.0;
        for (int i = 1; i < len; i++) {
            for (int j = i; j > 0; j--) {
                dp[i] += dp[j - 1] + 1;
            }
        }
        double sumWin = 0.0;
        double sumAll = 0.0;
        for (int i = a - 10 - 1; i < a; i++) {
            double pos;
            if (i + 1 + n >= b) {
                pos = diff/n;
                sumWin += dp[i] * pos;
            } else {
                pos = (double)(i+1+10-a+1)/n;
                sumWin += dp[i] * pos;
            }
            double pos2 = (double)(i+1+10-a+1)/n;
            pos2 = pos2 > 1 ? 1.0 : pos2;
            sumAll += dp[i] * pos2;
        }
        return sumWin / sumAll;
    }
}
