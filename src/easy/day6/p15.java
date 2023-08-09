package easy.day6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: p15
 * @Description: 三数之和
 * @author: lyz
 * @date: 2023 08 2023/8/1 22:33
 */

public class p15 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        String[] strArr = inputStr.split(" ");
        int[] nums = new int[strArr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strArr[i]);
        }
        List<List<Integer>> lists = threeSum(nums);

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            result.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return result;
        }
        Arrays.sort(nums);
        //单重循环+双指针思想
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> curList = new ArrayList<>();
                    curList.add(nums[i]);
                    curList.add(nums[left]);
                    curList.add(nums[right]);
                    //此处重点：去掉重复的三元组
                    if (!result.contains(curList)) {
                        result.add(curList);
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
