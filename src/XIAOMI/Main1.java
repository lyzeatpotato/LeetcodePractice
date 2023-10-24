package XIAOMI;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/23 15:46
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[0]);
        int radius = Integer.parseInt(split[1]);
        int[][] towers = new int[n][3];
        for (int i = 0; i < n; i++) {
            String curS = scan.nextLine();
            String[] curSplit = curS.split(",");
            towers[i][0] = Integer.parseInt(curSplit[0]);
            towers[i][1] = Integer.parseInt(curSplit[1]);
            towers[i][2] = Integer.parseInt(curSplit[2]);
        }
        System.out.println(getPosition(towers, radius));
    }

    public static String getPosition(int[][] towers, int radius) {
        int[] power = new int[towers.length];
        for (int i = 0; i < towers.length; i++) {
            for (int j = 0; j < towers.length; j++) {
                if (j != i) {
                    double d = Math.sqrt(Math.pow((towers[i][0] - towers[j][0]), 2) + Math.pow((towers[i][1] - towers[j][1]), 2));
                    if (d - radius <= 0) {
                        power[i] += (int)(towers[i][2] / (1 + d));
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < power.length; i++) {
            if (max < power[i]) {
                max = power[i];
                idx = i;
            } else if (max == power[i]) {
                if (towers[idx][0] > towers[i][0]) {
                    max = power[i];
                    idx = i;
                } else if (towers[idx][0] == towers[i][0]) {
                    if (towers[idx][1] > towers[i][1]) {
                        max = power[i];
                        idx = i;
                    }
                }
            }
        }
        return towers[idx][0] + "," + towers[idx][1];
    }
}
