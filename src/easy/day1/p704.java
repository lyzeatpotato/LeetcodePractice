package easy.day1;

import java.util.Scanner;

/**
 * @ClassName: p704
 * @Description: 二分查找
 * @author: lyz
 * @date: 2023 07 2023/7/26 21:58
 */

public class p704 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String numsStr = scan.nextLine();
        String[] strArr = numsStr.split(" ");

        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        int target = scan.nextInt();

        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                System.out.println(mid);
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(-1);
    }
}
