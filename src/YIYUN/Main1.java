package YIYUN;

import java.util.*;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/14 19:03
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int times = 1;
        Map<String, Integer> inputMap = new HashMap<>();
        while(times <= n) {
            String s = scan.nextLine();
            String[] s1 = s.split(" ");
            String str = s1[0];
            int p = Integer.parseInt(s1[1]);
            inputMap.put(str, p);
            times++;
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(inputMap.entrySet());
        list.sort(((o1, o2) -> o1.getValue().compareTo(o2.getValue())));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey());
        }
    }


}
