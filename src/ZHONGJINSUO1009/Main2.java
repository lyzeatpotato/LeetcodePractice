package ZHONGJINSUO1009;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/9 19:56
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s = in.nextLine();
        String substring = s.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[1]);
        int num3 = Integer.parseInt(split[2]);
        System.out.println(isTraingle(num1, num2, num3));
    }

    public static boolean isTraingle(int num1, int num2, int num3) {
        boolean res = true;
        if (num1 == num2 || num1 == num3 || num2 == num3) {
            res = false;
        }
        //找出顶部元素所在的行
        int n = getLine(num1);
        //获取num1为第几个元素
        int count1 = num1 - (n-1)*n/2 + 1;
        //判断num2是否在三角形线上
        int differ2 = num2 - num1;
        int cut2 = n;
        while (differ2 > 0) {
            differ2 -= cut2;
            cut2++;
            if (differ2 < 0) {
                res = false;
            }
        }
        //判断num3是否在三角形线上
        int differ3 = num3 - num1;
        int cut3 = n + 1;
        while (differ3 > 0) {
            differ3 -= cut3;
            cut3++;
            if (differ3 < 0) {
                res = false;
            }
        }
        return res;
    }

    public static int getLine(int num) {
        int line = 1;
        if (num == 1) {
            return line;
        }
        int sum = 0;
        for (int i = 1; sum < num; i++) {
            sum += i;
            line = i;
        }
        return line;
    }
}
