package easy.day5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: p1
 * @Description: 两数之和
 * @author: lyz
 * @date: 2023 08 2023/8/1 17:16
 */

public class p1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String inputStr = scan.nextLine();
        String[] numsArr = inputStr.split(" ");
        int[] nums = new int[numsArr.length];
        for (int i = 0; i < numsArr.length; i++) {
            nums[i] = Integer.parseInt(numsArr[i]);
        }
        int target = scan.nextInt();
        int[] ints = twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target) {
        //将nums存成一个key为nums[i]，value为i的map
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        //遍历nums在target中寻找（数组中同一个元素在答案里不能重复出现！）
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                int j = numsMap.get(target - nums[i]);
                if (i != j) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
