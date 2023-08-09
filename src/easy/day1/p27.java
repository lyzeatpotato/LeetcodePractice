package easy.day1;

import java.util.Scanner;

/**
 * @ClassName: p27
 * @Description: 移动数组
 * @author: lyz
 * @date: 2023 07 2023/7/26 22:14
 */

public class p27 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numsStr = scan.nextLine();
        String[] strArr = numsStr.split(" ");
        int[] nums = new int[strArr.length];    //数组
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int val = scan.nextInt();   //目标数

//        int index = 0;
//        int n = 0;  //记录有几个
//        while (index < nums.length - n) {
//            if (nums[index] == val) {
//                for (int i = index; i < nums.length - 1 - n; i++) {
//                    nums[i] = nums[i + 1];
//                }
//                nums[nums.length - 1 - n] = 0;
//                n++;
//            } else {
//                index++;
//            }
//        }
//        System.out.println(n);

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        //头尾指针法
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (left <= right) {
            for (int i = right; i >= left ; i--) {
                if (nums[right] == val) {
                    nums[i] = 0;
                    count++;
                    right--;
                } else {
                    break;
                }
            }
            if (nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = 0;
                right--;
                count++;
            }
            left++;
        }
        return n - count;
    }
}
