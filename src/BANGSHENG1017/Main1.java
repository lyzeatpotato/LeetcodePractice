package BANGSHENG1017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/17 22:10
 */

public class Main1 {
    public static void main(String[] args) {
        int t = 163;
        int k = 3;
        List<Integer> ls = Arrays.asList(50, 55, 56, 57, 58);
        System.out.println(chooseBestSum(t,k,ls));
    }

    public static int chooseBestSum(int t, int k, List<Integer> ls) {
        ls.sort((c1, c2) -> c1.compareTo(c2));
        int sum = 0;
        for (int i = 0; i < ls.size(); i++) {
            sum = 0;
            for (int j = i; j < k; j++) {
                sum += ls.get(j);
            }
            if (sum <= t) {
                return sum;
            } else {
                break;
            }
        }
        int res = sum;
        return res <= t ? res : 0;
    }
}
