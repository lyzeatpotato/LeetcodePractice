package easy.day001;

/**
 * @ClassName: p415
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/18 23:47
 */

public class p415 {
    public static void main(String[] args) {
        String num1 = "11";
        String num2 = "123";
        System.out.println(addStrings(num1 , num2));
    }

    public static String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int idx1 = n1 - 1;
        int idx2 = n2 - 1;
        int carry = 0;  // 表示进位
        StringBuffer sb = new StringBuffer();
        while (idx1 >= 0 || idx2 >= 0) {
            int val1 = idx1 >= 0 ? Integer.parseInt(String.valueOf(num1.charAt(idx1))) : 0;
            int val2 = idx2 >= 0 ? Integer.parseInt(String.valueOf(num2.charAt(idx2))) : 0;
            int value = val1 + val2 + carry;
            carry = value / 10;
            sb.append(String.valueOf(value % 10));
            if (idx1 >= 0) {
                idx1--;
            }
            if (idx2 >= 0) {
                idx2--;
            }
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
