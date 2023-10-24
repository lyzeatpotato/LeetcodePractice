package BAIDU;

import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/19 19:39
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int a = scan.nextInt();
            int b = scan.nextInt();
            if (x > y) {
                int temp = y;
                y = x;
                x = temp;
            }
            outputMinTimes(x, y, a, b);
        }
    }

    public static void outputMinTimes(int x, int y, int a, int b) {
        int operations = 0;

        while (x != y) {
            if (x < y) {
                if ((y - x) % 2 != 0 && a >= (y - x) % 2) { //差为奇数：选择奇数
                    x += a;
                } else if ((y - x) % 2 == 0 && b >= (y - x) % 2) {  //
                    x -= b;
                } else {
                    break;
                }
            } else {
                break;
            }
            operations++;
        }
        System.out.println(operations + 1);
    }

}
