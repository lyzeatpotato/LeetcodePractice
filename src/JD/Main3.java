package JD;

import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 10:35
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (scan.hasNextInt()) { // 注意 while 处理多个 case
            int n = scan.nextInt();     //  代表n行
            int m = scan.nextInt();     //  代表m列
            int maxn = 1010;
            int[][] pre = new int[maxn][maxn];

            int ans = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= m; ++j) {
                    pre[i][j] = scan.nextInt();
                    ans = Math.min(ans, pre[i][j]);
                    pre[i][j] += pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    for (int len = 0; i + len <= n && j + len <= m; len++) {
                        int t = pre[i + len][j + len] + pre[i - 1][j - 1];
                        int t2 = pre[n][m] - t;
                        ans = Math.min(ans, Math.abs(t - t2));
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
