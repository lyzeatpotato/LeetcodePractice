package JUREN0923;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/23 18:55
 */

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        System.out.println(minOperations(arr));
    }

    public static int minOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] <= nums[i + 1] && nums[i + 1] <= nums[i + 2]) {
                count++;
                if (i > 0 && nums[i + 2] <= nums[i - 1]) {
                    nums[i + 2] = nums[i + 1];
                } else {
                    nums[i + 1] = nums[i + 2] + 1;
                }
            }
        }
        return count;
    }


}
