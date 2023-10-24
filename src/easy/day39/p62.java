package easy.day39;

import java.util.Scanner;

/**
 * @ClassName: p62
 * @Description: 不同路径问题
 * @author: lyz
 * @date: 2023 09 2023/9/4 20:39
 */

public class p62 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int i = uniquePaths(m, n);
        System.out.println(i);
    }

    public static int uniquePaths(int m, int n) {
        //1.dp[i][j]表示在(i,j)处的可能路径数量
        //2.dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        //3.dp[0][j] = 1, dp[i][0] = 1
        //4.从左向右,从上向下
        /**
         * [
         *  0 1 1
         *  1 2 3
         * ]
         */
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
