package YONGYOU;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/18 19:33
 */

public class Main3 {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{3,8,5,2};
//        int[] nums2 = new int[]{2,4,1,6};
        int[] nums1 = new int[]{1,3,7,1};
        int[] nums2 = new int[]{4,3,1,4};
//        int k = 1;
        int k = 3;
        System.out.println(minOperations(nums1, nums2, k));
    }

    public static long minOperations(int[] nums1, int[] nums2, int k) {
        // write code here
        if (nums1.length != nums2.length) {
            return -1;
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) {
                list1.add(nums1[i]);
                list2.add(nums2[i]);
            }
        }
        //分别遍历两个list
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            int first = list1.get(i);
            int second = list2.get(i);
            while (first != second) {
                if (first < second) {
                    second -= k;
                    count++;
                    if (second > first) {
                        return -1;
                    }
                } else if (first > second) {
                    second += k;
                    count++;
                    if (second < first) {
                        return -1;
                    }
                } else {
                    list1.remove(i);
                    list2.remove(i);
                    break;
                }
            }
        }
        return count / 2;
    }
}
