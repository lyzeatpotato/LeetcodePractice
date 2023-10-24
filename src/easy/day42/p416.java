package easy.day42;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: p416
 * @Description: 分割等和子集
 * @author: lyz
 * @date: 2023 09 2023/9/15 10:49
 */

public class p416 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] s1 = s.split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        boolean b = canPartition(nums);
    }

    public static boolean canPartition(int[] nums) {
        int sum = Arrays.stream(Arrays.stream(nums).toArray()).sum();
        if (sum % 2 == 1) {
            return false;   //和为奇数肯定不能拆分
        }
        int half = sum/2;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int curSum = 0;
        while (curSum <= half) {
            if (curSum == half) {
                return true;
            }
            if (curSum + nums[right] <= half) {
                curSum += nums[right];
                right--;
            }
            if (curSum + nums[left] <= half) {
                curSum += nums[left];
                left++;
            }
        }
        return false;
    }
}
