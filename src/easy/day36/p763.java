package easy.day36;

import java.util.*;

/**
 * @ClassName: p763
 * @Description: 划分字母到同一区间
 * @author: lyz
 * @date: 2023 08 2023/8/30 17:06
 */

public class p763 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        List<Integer> integers = partitionLabels(s);
        integers.stream().forEach(System.out::println);
    }

    public static List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> charMap = new LinkedHashMap<>();      //定义一个空map来记录字符出现的次数
        for (int i = 0; i < chars.length; i++) {
            charMap.put(chars[i], i);
        }
        List<Integer> result = new ArrayList<>();
        //遍历char数组并找出下标与出现次数相同的
        int idx = 0;
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, charMap.get(chars[i]));
            if (idx == i) {
                result.add(idx - last + 1);
                last = idx + 1;
            }
        }
        return result;
    }
}
