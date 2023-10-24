package meituan.t0916;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/16 19:03
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] winArray = new int[n];
        for (int i = 0; i < n; i++) {
            winArray[i] = scan.nextInt();
        }
        int totalScore = getTotalScore(winArray);
        System.out.println(totalScore);
    }

    public static int getTotalScore(int[] arr) {
        int score;
        if (arr[0] == 1) {
            score = 1;
        } else {
            score = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == 1 && arr[i] == 1) {
                score += 2;
            } else if (arr[i - 1] != 1 && arr[i] == 1) {
                score += 1;
            }
        }
        return score;
    }
}
