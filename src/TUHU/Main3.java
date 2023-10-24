package TUHU;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/20 19:31
 */

public class Main3 {
    static boolean[][] visited;
    static int[][] move = {{0,1}, {0, -1}, {1, 0}, {-1 ,0}};

    public static void main(String[] args) {
        int[][] cities = new int[][] {{0,0}, {0,1}, {1,0}, {1,2}, {2,1}, {2,2}};
        System.out.println(minFactoryStores(cities));
    }

    public static int minFactoryStores (int[][] cities) {
        // write code here
        int res = 0;
        visited = new boolean[cities.length][cities[0].length];
        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities[0].length; j++) {
                if (!visited[i][j]) {
                    bfs(cities, i, j);
                    res++;
                }

            }
        }
        return res;
    }

    public static void bfs(int[][] cities, int y, int x) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {y, x});
        visited[y][x] = true;
        int idx = 1;
        while (!deque.isEmpty()) {
            int[] cur = deque.poll();
            int m = cur[0];
            int n = cur[1];
            for (int i = 0; i < 4; i++) {
                int nexty = m + move[i][0];
                int nextx = n + move[i][1];
                if (nextx < 0 || nexty == cities.length || nexty < 0 || nextx == cities[0].length) {
                    continue;
                }
                if (!visited[nexty][nextx]) {
                    deque.offer(new int[] {nexty, nextx});
                    visited[nexty][nextx] = true;
                    idx++;
                }
            }
        }
    }
}
