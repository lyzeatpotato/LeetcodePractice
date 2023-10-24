package easy.day36;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: p56
 * @Description: 合并区间
 * @author: lyz
 * @date: 2023 08 2023/8/30 18:14
 */

public class p56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = new int[][]{{1, 3}};
//        int[][] intervals = new int[][]{{1, 4}, {5, 6}};
        int[][] merge = merge(intervals);
    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        //首先对区间进行去重
        //1.对区间按照左边界排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //2.对区间进行去重
        int leftBound = intervals[0][0];
        int rightBound = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > rightBound) {
                //情况1.没有交叉且不相贴
                result.add(new int[] {leftBound, rightBound});
                leftBound = intervals[i][0];
                rightBound = intervals[i][1];
            } else {
                //情况2.存在重合或贴贴部分,直接更新右边界(重合区域看作是一块)
                rightBound = Math.max(rightBound, intervals[i][1]);
            }
        }
        //因为是i从1开始遍历,所以最后注意补上最后一个
        result.add(new int[] {leftBound, rightBound});
        return result.toArray(new int[result.size()][]);
    }
}
