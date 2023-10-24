package TONGCHENG581014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/14 19:07
 */

public class Main1 {
    public static void main(String[] args) {
        // [1,2,3,7],[2,5,7]
        int[] docList1 = new int[] {1,2,3,7};
        int[] docList2 = new int[] {2,5,7};
        int[] ints = intersectionAndSort(docList1, docList2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] intersectionAndSort (int[] docList1, int[] docList2) {
        // write code here
        Arrays.sort(docList1);
        Arrays.sort(docList2);
        List<Integer> res = new ArrayList<>();
        int first = docList1.length - 1;
        int second = docList2.length - 1;
        while (first >= 0 && second >= 0) {
            if (docList1[first] == docList2[second]) {
                res.add(docList1[first]);
                first--;
                second--;
            } else if (docList1[first] > docList2[second]) {
                first--;
            } else {
                second--;
            }
        }
//        for (int i = docList1.length - 1; i >= 0; i--) {
//            for (int j = docList2.length - 1; j >= 0; j--) {
//                if (docList1[i] == docList2[j]) {
//                    res.add(docList1[i]);
//                }
//            }
//        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
