package TUHU;

import BAIDU.Main;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/20 19:22
 */

public class Main1 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(getTotalWays(grid));;
    }

    public static int getTotalWays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化dp数组
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
