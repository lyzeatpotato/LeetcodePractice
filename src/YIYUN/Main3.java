package YIYUN;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/14 19:32
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        System.out.println(getMatrixNum(matrix));
    }

    public static int getMatrixNum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] dp = new int[m];  //dp[i]表示当前行所需的最小删除次数
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] >= matrix[i][j - 1]) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j]++;
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
