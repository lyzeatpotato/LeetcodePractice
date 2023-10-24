package easy.day35;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: p860
 * @Description: 柠檬水找零
 * @author: lyz
 * @date: 2023 08 2023/8/29 9:57
 */

public class p860 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] input = s.split(" ");
        int[] bills = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            bills[i] = Integer.parseInt(input[i]);
        }
        boolean result = lemonadeChange(bills);
        System.out.println(result);
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;  //记录三种面值的数量
        for (int i = 0; i < bills.length; i++) {
            switch (bills[i]) {
                case 5:
                    five++;     //不用找零不做任何操作
                    System.out.println("收到一张5元，不找零");
                    break;
                case 10:
                    ten++;      //需要找一张5元，没有则出错
                    if (five == 0) {
                        return false;
                    }
                    five--;
                    System.out.println("收入一张10元，找零5元");
                    break;
                case 20:
                    twenty++;   //需要找15元，优先10+5
                    if (five == 0) {
                        return false;
                    } else if (ten == 0) {
                        if (five <3) {
                            return false;
                        } else {
                            five -= 3;
                            System.out.println("收到一张20元，找零3张5元");
                        }
                    } else {
                        ten--;
                        five--;
                        System.out.println("收到一张20元，找零1张10元1张5元");
                    }
                    break;
                default:
                    continue;
            }
        }
        return true;
    }
}
