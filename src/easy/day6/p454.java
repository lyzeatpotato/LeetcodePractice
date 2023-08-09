package easy.day6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: p454
 * @Description: 四数相加Ⅱ
 * @author: lyz
 * @date: 2023 08 2023/8/1 17:54
 */

public class p454 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();    //一定要记得跳到第二行
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        String s3 = scan.nextLine();
        String s4 = scan.nextLine();
        int[] nums1 = getArrayByStr(s1);
        int[] nums2 = getArrayByStr(s2);
        int[] nums3 = getArrayByStr(s3);
        int[] nums4 = getArrayByStr(s4);
        int res = fourSumCount(nums1, nums2, nums3, nums4);
    }

    public static int[] getArrayByStr(String s) {
        String[] sArr = s.split(" ");
        int[] result = new int[sArr.length];
        for (int i = 0; i < sArr.length; i++) {
            result[i] = Integer.parseInt(sArr[i]);
        }
        return result;
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        //分别统计前后两个数组可能产生的结果
        Map<Integer, Integer> firstResultMap = findPossibleResults(nums1, nums2);
        Map<Integer, Integer> secondResultMap = findPossibleResults(nums3, nums4);
        for (Integer key : firstResultMap.keySet()) {
            if (secondResultMap.containsKey(0 - key)) {
                count += firstResultMap.get(key) * secondResultMap.get(0 - key);
            }
        }
        return count;
    }

    public static Map<Integer, Integer> findPossibleResults(int[] arr1, int[] arr2) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                int curRes = arr1[i] + arr2[j];
                if (resultMap.containsKey(curRes)) {
                    resultMap.put(curRes, resultMap.get(curRes) + 1);
                } else {
                    resultMap.put(curRes, 1);
                }
            }
        }
        return resultMap;
    }
}
