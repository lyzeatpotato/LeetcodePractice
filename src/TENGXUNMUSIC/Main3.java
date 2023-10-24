package TENGXUNMUSIC;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/22 19:39
 */

public class Main3 {

    static int mod = 1000000007;
    public static void main(String[] args) {
        String t = "ababac";
        System.out.println(cntOfMethod(t));
    }

    public static int cntOfMethod (String t) {
        // write code here
        //1.dp[i]表示substring(0,i)共有dp[i]种生成方式
        //2.当t[i]不存在于之前那的子串当中时，dp[i] = dp[i - 1]
        //  当t[i]存在与已生成的字串且以t[i]开头长度大于等于2的子串与其后的相同，dp[i] = dp[i - 1] + 1;
        //3.dp[0] = 1
        int n = t.length();
        if (n <= 3) {
            return 1;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        String isLooped = t.substring(0,1);       //记录已经遍历过的子串
        for (int i = 1; i < n; i++) {
            String charAt = String.valueOf(t.charAt(i));
            if (!isLooped.contains(charAt)) {
                dp[i] = dp[i - 1];
            } else {
                if (i + 2 <= n ) {
                    int flag = 0;
                    while (flag < isLooped.length()) {
                        if (t.charAt(i) == isLooped.charAt(flag) && flag + 2 <= isLooped.length()) {
                            if (isLooped.substring(flag, flag + 2).equals(t.substring(i, i + 2))) {
                                dp[i] = dp[i - 1] + 1;
                                break;
                            }
                        } else {
                            dp[i] = dp[i - 1];
                        }
                        flag++;
                    }
                }else {
                    dp[i] = dp[i - 1];
                }
            }
            isLooped += charAt;
        }
        return dp[n - 1];
    }
}
