package XIMALAYA0924;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 19:00
 */

public class Main1 {
    public static void main(String[] args) {
//        int[] nums = new int[] {1, -3, 2, 3, -4};
        int[] nums = new int[] {2, -5, 1, -4, 3, -2};
        System.out.println(maxAbsoluteSum(nums));
    }

    public static int maxAbsoluteSum (int[] nums) {
        // write code here
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxAbsSum = Math.abs(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int newMaxSum = Math.max(num, maxSum + num);
            int newMinSum = Math.min(num, minSum + num);
            maxAbsSum = Math.max(maxAbsSum, Math.max(Math.abs(newMaxSum), Math.abs(newMinSum)));
            maxSum = newMaxSum;
            minSum = newMinSum;
        }
        return maxAbsSum;
    }
}
