package xiecheng.second;

import java.util.*;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/21 19:06
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scan.nextInt();
        }
        getRangedNums(nums);
    }

    public static void getRangedNums(int[] nums) {
        int[] arr = new int[nums.length];
        int[] clone = nums.clone();
        Arrays.sort(clone);
        boolean[] used = new boolean[clone.length];
        for (int i = 0; i < clone.length; i++) {
            used[i] = false;
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < used.length; j++) {
                if (!used[j]) {
                    if (clone[j] == nums[i]) {
                        index++;
                    } else {
                        arr[i] = clone[j];
                        used[j] = true;
                        break;
                    }
                }
            }
        }
        if (arr[arr.length - 1] == 0) {
            arr[arr.length - 1] = arr[arr.length - 2];
            arr[arr.length - 2] = clone[arr.length - 1];
        }
        //输出数组
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
