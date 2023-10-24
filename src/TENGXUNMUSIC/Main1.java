package TENGXUNMUSIC;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/22 19:06
 */

public class Main1 {
    public static void main(String[] args) {
        int num = 52;
        System.out.println(fun(num));
    }

    public static int fun (int n) {
        // write code here
        int res = 0;
        if (n % 5 == 0)
            return res;
        String s = String.valueOf(n);
        while (n%5 != 0) {
            if (s.length() > 1) {
                s = s.substring(0, s.length() - 1);
            }
            n = Integer.parseInt(s);
            res++;
        }
        return res;
    }
}
