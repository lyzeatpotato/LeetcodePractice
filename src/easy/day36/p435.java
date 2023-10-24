package easy.day36;

import java.util.Arrays;

/**
 * @ClassName: p435
 * @Description: 无重叠区间
 * @author: lyz
 * @date: 2023 08 2023/8/30 11:51
 */

public class p435 {
    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        int[][] intervals = new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}};
        int i = eraseOverlapIntervals(intervals);
        System.out.println(i);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        //首先还是以左边界进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //根据有序的列表边界，判断是否存在重叠区域
        int uneraseCount = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                continue;
            } else {
                uneraseCount++;     //非重叠区域计算数量更新
            }
        }
        return intervals.length - uneraseCount;
    }
}
