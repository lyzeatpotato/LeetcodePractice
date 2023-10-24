package YONGYOU;

import java.util.Scanner;

/**
 * @ClassName: DEWU.Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/18 19:29
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        System.out.println(getTotalWays(m+1, n+1));
    }

    public static int getTotalWays(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化dp数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
