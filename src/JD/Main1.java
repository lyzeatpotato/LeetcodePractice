package JD;

import java.util.Scanner;

/**
 * @ClassName: Main
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 10:06
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int l1 = scan.nextInt();
        int r1 = scan.nextInt();
        int l2 = scan.nextInt();
        int r2 = scan.nextInt();
        int l3 = scan.nextInt();
        int r3 = scan.nextInt();
        int[] range1 = new int[] {l1, r1};
        int[] range2 = new int[] {l2, r2};
        int[] range3 = new int[] {l3, r3};
        int maxCom1 = findMaxCom(range1, range2);
        int maxCom2 = findMaxCom(range1, range3);
        int maxCom3 = findMaxCom(range2, range3);
        int max = Math.max(maxCom2, maxCom3);
        System.out.println(maxCom1 > max ? maxCom1 : max);
    }

    public static int findMaxCom(int[] range1, int[] range2) {
        if (range1[1] < range2[0] || range2[1] < range1[0]) {
            return -1;
        } else {
            return 2 * Math.min(range1[1], range2[1]);
        }
    }
}
