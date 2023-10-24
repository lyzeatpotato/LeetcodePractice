package easy.day35;

import java.util.Arrays;

/**
 * @ClassName: p452
 * @Description: 用最少箭的数量引爆全部气球
 * @author: lyz
 * @date: 2023 08 2023/8/30 10:01
 */

public class p452 {
    public static void main(String[] args) {
//        int[][] points = new int[][] {{10, 16}, {2, 8}, {1, 6}, {7,12}};
        int[][] points = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}};
//        int[][] points = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int minArrowShots = findMinArrowShots(points);
        System.out.println(minArrowShots);
    }

    public static int findMinArrowShots(int[][] points) {
        //首先对全部的气球按照左边界排序（）
//        for (int i = 0; i < points.length - 1; i++) {
//            for (int j = i; j < points.length - i - 1; j++) {
//                if (points[j][0] > points[j + 1][0]) {
//                    int[] temp = points[j + 1];
//                    points[j + 1] = points[j];
//                    points[j] = temp;
//                }
//            }
//        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;  //最少也需要一支箭
        //找出最小的重合边界
        for (int i = 1; i < points.length; i++) {
            if (points[i - 1][1] < points[i][0]) {
                //此时没有重合情况，必须要增加一支箭来刺穿气球
                count++;
            } else {
                //存在重合情况，更新最左侧的边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return count;
    }

}

