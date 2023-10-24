package SHEIN;

import java.util.Scanner;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/23 13:41
 */

public class Main2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String[] split = s.split(",");
        int n = Integer.parseInt(split[1]);
        System.out.println(convertStr(split[0], n));
    }

    public static String convertStr(String s, int numRows) {
        String result = "";
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        for (int rows = 0; rows < numRows; rows++) {
            int first = rows;
            int second = 2 * numRows  - 2 - rows;
            for (; first < s.length(); ) {
                result += s.charAt(first);
                if (rows != 0 && rows != numRows - 1 && second < s.length()) {
                    result += s.charAt(second);
                }
                first += 2 * numRows - 2;
                second += 2 * numRows - 2;
            }
        }
        return result;
    }
}
