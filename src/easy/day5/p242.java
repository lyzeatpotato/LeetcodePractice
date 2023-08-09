package easy.day5;

import java.util.*;

/**
 * @ClassName: p242
 * @Description: 有效的字母异位词
 * @author: lyz
 * @date: 2023 07 2023/7/31 15:14
 */

public class p242 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String t = scan.nextLine();
        isAnagram(s, t);
    }

    public static boolean isAnagram(String s, String t) {
        //首先判断字符串长度
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sKey = s.charAt(i);
            char tKey = t.charAt(i);
            if (sMap.containsKey(sKey)) {
                sMap.put(sKey, sMap.get(sKey) + 1);
            } else {
                sMap.put(sKey, 1);
            }
            if (tMap.containsKey(tKey)) {
                tMap.put(tKey, tMap.get(tKey) + 1);
            } else {
                tMap.put(tKey, 1);
            }
        }
        //比较两个map
        if (sMap.equals(tMap)) {
            return true;
        } else {
            return false;
        }
    }
}
