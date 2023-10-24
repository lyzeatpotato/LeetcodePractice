package meituan.t0916;

import java.util.Scanner;

/**
 * @ClassName: Mian4
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/16 19:38
 */

public class Mian4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        int totalM = getTotalM(arr);
        System.out.println(totalM);
    }

    public static int getTotalM(int[] arr) {
        int maxM = 0;
        for (int i = 0; i < arr.length; i++) {
            int m = 0;
            for (int j = i + 1; j < arr.length; j++) {
                m = Math.max(m, 1);
                int res = arr[i] & arr[j];
                double cut = Math.pow(2, m);
                while (res != 0 && res % cut == 0) {
                    m++;
                    cut = Math.pow(2, m);
                }
            }
            maxM = Math.max(maxM, m - 1);
        }
        return maxM;
    }
}
