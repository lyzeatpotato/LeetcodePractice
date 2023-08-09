package xiecheng;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            // 情况一：以 a[i] 为中心的回文子串
            ans += countPalindrome(a, i, i);
            // 情况二：以 a[i] 和 a[i+1] 为中心的回文子串
            if (i < n - 1 && a[i] == a[i+1]) {
                ans += countPalindrome(a, i, i+1);
            }
        }
        System.out.println(ans % 1000000007);
    }

    private static long countPalindrome(int[] a, int i, int j) {
        int n = a.length;
        long cnt = 0;
        while (i >= 0 && j < n && a[i] == a[j]) {
            cnt += a[i];
            i--;
            j++;
        }
        return cnt;
    }
}