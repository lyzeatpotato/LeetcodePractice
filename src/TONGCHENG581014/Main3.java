package TONGCHENG581014;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/14 20:07
 */

public class Main3 {
    public static void main(String[] args) {
        System.out.println(minTolls(new int[] {10,1,1,1,10,1,1,10}));
    }

    public static int minTolls (int[] toll) {
        // write code here
        int[] dp = new int[toll.length];
        dp[0] = toll[0];
        dp[1] = toll[1];
        for (int i = 2; i < toll.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + toll[i];
        }
        return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}
