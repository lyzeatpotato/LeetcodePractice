package LianNeng;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: DEWU.Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/17 16:40
 */

public class Main2 {
    static int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) {
        String[] board = new String[] {"XYZE", "SFZS", "XDEE"};
        String word = "XYZY";
        exist(board, word);
    }

    public static boolean exist (String[] board, String word) {
        // write code here
        int m = board.length;
        int n = board[0].length();
        char[][] boardChar = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boardChar[i][j] = board[i].charAt(j);
            }
        }
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //分别从每一个字符位置处开始进行广度优先搜索
                if (dfs(boardChar, visited, word, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs (char[][] board, boolean[][] visited, String word, int y, int x) {
        if (board[y][x] != word.charAt(0)) {
            return false;
        }
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
                if (nextx < 0 || nexty == board.length || nexty < 0 || nextx == board[0].length) {
                    continue;
                }
                if (!visited[nexty][nextx] && board[nexty][nextx] == word.charAt(idx)) {
                    deque.offer(new int[] {nexty, nextx});
                    visited[nexty][nextx] = true;
                    idx++;
                    if (idx == word.length()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
