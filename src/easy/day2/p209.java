package easy.day2;

import java.util.Scanner;

/**
 * @ClassName: p209
 * @Description: 长度最小的连续子数组
 * @author: lyz
 * @date: 2023 07 2023/7/27 23:14
 */

public class p209 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();
        String[] strArr = numStr.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int target = scan.nextInt();
        int result = minSubArray(target, nums);
    }

    public static int minSubArray(int target, int[] nums) {
        int minArrLength = Integer.MAX_VALUE;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum >= target) {
                if (minArrLength > end - start + 1) {
                    minArrLength = end - start + 1;
                }
                sum -= nums[start] + nums[end];
                start ++;
                end --;
            }
        }
        return minArrLength == Integer.MAX_VALUE ? minArrLength:0;
    }
}
