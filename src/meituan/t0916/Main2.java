package meituan.t0916;

import java.util.Scanner;

/**
 * @ClassName: DEWU.Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/16 19:08
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int shotScore = getShotScore(x, y);
        System.out.println(shotScore);
    }

    public static int getShotScore(int x, int y) {
        //计算坐标距离远点的距离
        double distance = Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
        int score = 0;
        for (int i = 1; i <= 10; i++) {
            if (distance <= i) {
                score += 11 - i;
                break;
            }
        }
        return score;
    }
}
