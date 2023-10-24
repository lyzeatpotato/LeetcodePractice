package DEWU;

import java.util.Scanner;

/**
 * @ClassName: DEWU
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/20 21:21
 */

public class Main2 {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String s = scan.next();
        System.out.println(getNumericalStr(s));
    }

    public static int getNumericalStr(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        //1.dp[i]表示当前字符位置可能对应的8进制情况
        dp[0] = 1;
        if (s.charAt(0) == '1' && (s.charAt(0) == '1' || s.charAt(0) == '0')) {
            dp[1] = dp[0] + 1;
        }
        for (int i = 1; i <= n; i++) {
            char cur = s.charAt(i - 1);

            if (i > 1) {
                if (cur == '1') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[n];
    }
}