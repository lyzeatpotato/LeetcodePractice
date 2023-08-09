package easy.day6;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: p383
 * @Description: 救赎金
 * @author: lyz
 * @date: 2023 08 2023/8/1 22:19
 */

public class p383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean b = canConstruct(ransomNote, magazine);
    }

    public static boolean canConstruct (String ransomNote, String magazine) {
        Map<Character, Integer> rMap = new HashMap<>();
        Map<Character, Integer> mMap = new HashMap<>();
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        //对第二个构成字符串，解析为字符map
        for (int i = 0; i < magazine.length(); i++) {;
            char curChar = magazine.charAt(i);
            if (mMap.containsKey(curChar)) {
                mMap.put(curChar, mMap.get(curChar) + 1);
            } else {
                mMap.put(curChar, 1);
            }
        }
        //遍历第一个字符串，如出现字符串二字符数量不足或
        for (int i = 0; i < ransomNote.length(); i++) {
            char ranChar = ransomNote.charAt(i);
            if (!mMap.containsKey(ranChar)) {
                return false;
            }
            if (mMap.get(ranChar) <= 0) {
                return false;
            }
            mMap.put(ranChar, mMap.get(ranChar) - 1);
        }
        return true;
    }
}
