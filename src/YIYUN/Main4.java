package YIYUN;

import java.util.Scanner;

/**
 * @ClassName: Main4
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/14 20:03
 */

public class Main4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(getTotalCount(n));
    }

    public static int getTotalCount(int n) {
        int[] dp = new int[n + 1];  //dp[i]表示输入数字i时候的最大可能值
        if (n <= 5) {
            dp[n] = 2;
        }
        for (int i = 6; i < n; i++) {
            dp[i] = dp[i - 3] * dp[i - 3] + 2;
        }
        return dp[n];
    }
}
