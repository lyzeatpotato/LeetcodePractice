package MIHAYOU0924;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 20:16
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int h = scan.nextInt();
        int[][] cards = new int[n][2];
        for (int i = 0; i < n; i++) {
            cards[i][0] = scan.nextInt();
            cards[i][1] = scan.nextInt();
        }
        System.out.println(getPosibility(h, cards));
    }

    public static double getPosibility(int h, int[][] cards) {
        int luckyCoins = 0;     //记录幸运币的数量
        double posibility = 0;
        for (int i = 0; i < cards.length; i++) {
            int t = cards[i][0];
            int x = cards[i][1];
            if (t == 1) {
                //时来运转
                luckyCoins += x;
            } else {
                //幸运一掷
                h -= x;    //造成幸运币个数的伤害
                if (h <= 0 || luckyCoins >= h) {    //至少投出1
                    return 1;
                } else if (h > 6 * luckyCoins){
                    return 0;
                } else if (luckyCoins == 1){
                    posibility += (7 - h) / 6.0;
                } else {
                    int count = 0;
                    for (int j = luckyCoins - 1; j < 6 * (luckyCoins - 1); j++) {
                        for (int k = 1; k < 6; k++) {
                            if (j + k >= h) {
                                break;
                            } else {
                                count ++;
                            }
                        }
                    }
                    posibility += (Math.pow(6,luckyCoins) - count)/Math.pow(6,luckyCoins);
                }
            }
        }
        return posibility;
    }
}
