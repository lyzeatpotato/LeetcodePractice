package ZHONGJINSUO1009;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/9 20:24
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int[] prices = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            prices[i] = Integer.parseInt(split[i]);
        }
        int fee = in.nextInt();
        System.out.println(getFrees(prices, fee));
    }

    public static int getFrees(int[] prices, int fee) {
        int total = 0;
        OptionalInt min = Arrays.stream(prices).min();
        OptionalInt max = Arrays.stream(prices).max();
        return fee;
    }
}
