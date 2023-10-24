package xiecheng.second;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/21 19:21
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        for (int i = 0; i < q; i++) {
            String s = scan.next();
            String t = scan.next();
            System.out.println(isChangable(s,t));
        }
    }

    public static String isChangable(String s, String t) {
        if (s.equals(t)) {
            return "YES";
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        //将s串中所有字符放入map中
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (sMap.containsKey(charAt)) {
                sMap.put(charAt, sMap.get(charAt) + 1);
            } else {
                sMap.put(charAt, 1);
            }
        }
        //将t串中所有字符放入map中
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            if (tMap.containsKey(charAt)) {
                tMap.put(charAt, tMap.get(charAt) + 1);
            } else {
                tMap.put(charAt, 1);
            }
        }
        if (sMap.size() < tMap.size()) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
