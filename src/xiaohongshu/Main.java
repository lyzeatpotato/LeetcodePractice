package xiaohongshu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        //初始化帖子列表
        List<int[]> read = new ArrayList<>();

        //读取每个精华帖子的区间
        for (int i = 0; i < m; i++) {
            int li = scan.nextInt();
            int ri = scan.nextInt();


            for (int j = li - 1; j < ri - 1; j++) {
                read.add(new int[] {j + 1, j + 2});
            }
        }

        // 预计最对精华帖数量
        int max = 0;
        for (int i = 0; i < read.size(); i++) {
            int start = read.get(i)[0];
            int maxNow = 0;
            for (int j = 1; j < read.size(); j++) {
                if (read.get(j)[1] <= k + start) {
                    maxNow++;
                }
            }
            if (max < maxNow) {
                max = maxNow;
            }
        }
        System.out.println(max);
    }
}
