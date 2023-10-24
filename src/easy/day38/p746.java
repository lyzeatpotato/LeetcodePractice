package easy.day38;

import java.util.Scanner;

/**
 * @ClassName: p746
 * @Description: 使用最小费用爬楼梯
 * @author: lyz
 * @date: 2023 09 2023/9/2 0:17
 */

public class p746 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int[] cost = new int[s1.length];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.parseInt(s1[i]);
        }
        int i = minCostClimbingStairs(cost);
        System.out.println(i);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        if (n == 3) {
            return Math.min(cost[0] + cost[2], cost[1]);
        }
        dp[n - 1] = cost[n - 1];
        dp[n - 2] = cost[n - 2];
        for (int i = n - 3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}
