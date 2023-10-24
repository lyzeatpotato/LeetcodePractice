package YIYUN;

import java.util.*;

/**
 * @ClassName: DEWU.Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/14 19:14
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] s = input.split(" ");
        getWordCount(s);
    }

    public static String getWordCount(String[] s) {
        //将字符串数组的全部小写字母字符拼接成一个完整的字符串
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length; i++) {
            char[] chars = s[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] >= 'a' && chars[j] <= 'z') {
                    sb.append(chars[j]);
                }
            }
        }
        String bigString = sb.toString();
        //在字符串中统计字符出现的次数
        char[] bigChar = bigString.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < bigChar.length; i++) {
            if (map.containsKey(bigChar[i])) {
                map.put(bigChar[i], map.get(bigChar[i]) + 1);
            } else {
                map.put(bigChar[i], 1);
            }
        }
        //对map排序
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(((o1, o2) -> o2.getValue().compareTo(o1.getValue())));
        //输出第二的元素
        if (list.size() < 2) {
            return "ERROR";
        }
        if (list.get(0).getValue() != list.get(1).getValue()) {
            return list.get(1).getKey() + "-" + list.get(1).getValue();
        } else {
            return "ERROR";
        }
    }
}
