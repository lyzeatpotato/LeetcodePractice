package easy.day5;

import java.util.*;

/**
 * @ClassName: p349
 * @Description: 两个数组的交集
 * @author: lyz
 * @date: 2023 08 2023/8/1 10:49
 */

public class p349 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        String[] sArr = s.split(" ");
        String[] tArr = t.split(" ");
        int[] nums1 = new int[sArr.length];
        int[] nums2 = new int[tArr.length];
        for (int i = 0; i < sArr.length; i++) {
            nums1[i] = Integer.parseInt(sArr[i]);
        }
        for (int i = 0; i < tArr.length; i++) {
            nums2[i] = Integer.parseInt(tArr[i]);
        }
        int[] intersection = intersection(nums1, nums2);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> num1Map = new HashMap<>();
        //统计nums1元素出现的次数
        for (int i = 0; i < nums1.length; i++) {
            if (num1Map.containsKey(nums1[i])) {
                int item = num1Map.get(nums1[i]);
                num1Map.put(nums1[i], item + 1);
            } else {
                num1Map.put(nums1[i], 1);
            }
        }
        //判断nums2中出现的内容
        for (int i = 0; i < nums2.length; i++) {
            if (num1Map.containsKey(nums2[i]) && !result.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
