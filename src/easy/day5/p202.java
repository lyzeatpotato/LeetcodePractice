package easy.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: p202
 * @Description: 快乐数
 * @author: lyz
 * @date: 2023 08 2023/8/1 11:16
 */

public class p202 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        boolean happy = isHappy(n);
    }

    public static boolean isHappy(int n) {
        Map<Integer, Integer> result = new HashMap<>();
        while (n != 1) {
            //通过除法获取n的每一位数字并计算最终得数
            int curSum = 0;
            for (int i = n; i > 0; i = i / 10) {
                int cur = i % 10;
                curSum += cur * cur;
            }
            if (result.containsKey(curSum)) {
                return false;
            } else {
                result.put(curSum, 1);
            }
            n = curSum;
        }
        return true;
    }
}
