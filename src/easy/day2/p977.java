package easy.day2;

import java.util.Scanner;

/**
 * @ClassName: p977
 * @Description: 有序数组平方
 * @author: lyz
 * @date: 2023 07 2023/7/27 18:29
 */

public class p977 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numStr = scan.nextLine();
        String[] strArr = numStr.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }

        // 收尾指针法
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        int[] newNums = new int[nums.length];
        while (left < right && index >=0) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                newNums[index] = nums[left] * nums[left];
                left++;
                index--;
            } else {
                newNums[index] = nums[right] * nums[right];
                right--;
                index--;
            }
        }
        for (int a : nums) {
            System.out.println(a);
        }
    }
}
