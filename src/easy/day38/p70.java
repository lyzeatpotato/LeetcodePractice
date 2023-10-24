package easy.day38;

import java.util.Scanner;

/**
 * @ClassName: p70
 * @Description: 爬楼梯
 * @author: lyz
 * @date: 2023 09 2023/9/2 0:00
 */

public class p70 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nextInt = scan.nextInt();
        int i = climbStairs(nextInt);
        System.out.println(i);
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        if (n <= 2) {
            return n;
        }
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
