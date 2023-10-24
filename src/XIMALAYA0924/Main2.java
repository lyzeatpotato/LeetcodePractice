package XIMALAYA0924;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/24 19:08
 */

public class Main2 {
    public static void main(String[] args) {
        int[] nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates (int[] nums) {
        // write code here
        if (nums.length == 0) {
            return 0;
        }
        int idx = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[idx]) {
                idx++;
                nums[idx] = nums[i];
            }
        }
        return idx + 1;
    }
}
