import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: try1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/21 12:00
 */

public class try1 {
    static int mod = 100000007;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scan.nextInt();
            }
        }
        System.out.println(getValue(nums));
    }

    public static int getValue(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        int sum = 0;
        boolean[][] isUsed = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                isUsed[i][j] = false;
            }
        }
        for (int j = 0; j < m; j++) {

            for (int i = 0; i < n; i++) {
                int left = 0;
                int right = m - 1;
                while (left < right && isUsed[i][left]) {
                    left++;
                }
                while (left < right && isUsed[i][right]) {
                    right--;
                }
                if (nums[i][left] <= nums[i][right]) {
                    sum += nums[i][left] * Math.pow(2, (j + 1));
                    isUsed[i][left] = true;
                } else {
                    sum += nums[i][right] * Math.pow(2, (j + 1));
                    isUsed[i][right] = true;
                }
            }
        }

        return sum % mod;
    }
}
