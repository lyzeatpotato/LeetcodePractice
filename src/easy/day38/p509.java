package easy.day38;

import java.util.Scanner;

/**
 * @ClassName: p509
 * @Description: 斐波那契数列
 * @author: lyz
 * @date: 2023 09 2023/9/1 23:39
 */

public class p509 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nextInt = scan.nextInt();
        int fib = fib(nextInt);
        System.out.println(fib);
    }

    public static int fib(int n) {
        int[] dp = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
