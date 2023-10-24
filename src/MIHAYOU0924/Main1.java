package MIHAYOU0924;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 20:00
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scan.nextInt();
        }
        System.out.println(getMaxYiHuo(a, b));
    }

    public static int getMaxYiHuo(int[] a, int[] b) {
        int n = a.length;
        int max = Integer.MIN_VALUE;

        int sum1 = Arrays.stream(a).sum();
        int sum2 = Arrays.stream(b).sum();
        for (int i = 0; i < n; i++) {
            int tempA = removeElemet(a, i);
            int tempB = removeElemet(b, i);

            max = Math.max(max, Math.max(tempA ^ sum2, sum1 ^ tempB));
        }
        return max;
    }

    public static int removeElemet(int[] arr, int index) {
        int sum = 0;
        if (arr == null || index < 0 || index >= arr.length) {
            return Arrays.stream(arr).sum();
        }
        int[] result = new int[arr.length - 1];

        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                sum += arr[i];
                result[j++] = arr[i];
            }
        }
        return sum;
    }
}
