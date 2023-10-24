package easy.day001;

/**
 * @ClassName: p43
 * @Description: 43. 字符串相乘.给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @author: lyz
 * @date: 2023 10 2023/10/18 21:11
 */

public class p43 {
    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        // 将多位数乘法-->多位数*一位数  num1 * num2
        String[] multiStrings = new String[n2];
        String ans = "0";
        for (int i = n2 - 1; i >= 0; i--) {     // 从后往前遍历num2
            StringBuffer sb = new StringBuffer();
            for (int j = i; j < n2 - 1; j++) {
                sb.append("0");
            }
            int cur2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int carry = 0;
            for (int j = n1 - 1; j >= 0; j--) {     // 从后往前遍历num1
                int cur1 = Integer.parseInt(String.valueOf(num1.charAt(j)));
                int value = cur2 * cur1 + carry;
                carry = value / 10;
                sb.append(String.valueOf(value % 10));
            }
            if (carry != 0) {
                sb.append(String.valueOf(carry));
            }
            ans = addStrings(ans, sb.reverse().toString());
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
