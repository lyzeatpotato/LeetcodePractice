package easy.day2;

import java.util.Scanner;

/**
 * @ClassName: p59
 * @Description: 螺旋矩阵
 * @author: lyz
 * @date: 2023 07 2023/7/27 23:44
 */

public class p59 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        generateMatrix(n);
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int start = 0;  //每次轮回循环开始的点
        int num = 1;    //每次填充的数字
        int level = 0;  //水平方向变化坐标
        int straight = 0;   //垂直方向变化坐标
        for (int index = start; index < n/2; index++) {
            //上方：从左到右
            for (level = start; level < n - index - 1; level++) {
                result[start][level] = num;
                num++;
            }
            //右方：从上到下
            for (straight = start; straight < n - index - 1; straight++) {
                result[straight][level] = num;
                num++;
            }
            //下方：从右到左
            for (; level > index; level--) {
                result[straight][level] = num;
                num++;
            }
            //左方：从下向上
            for (; straight > index; straight--) {
                result[straight][level] = num;
                num++;
            }
            start++;
        }
        if (n % 2 == 1) {
            result[n/2][n/2] = num;
        }
        return result;
    }
}
