package xiecheng.second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/21 20:07
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String next = scan.next();
            for (int j = 0; j < next.length(); j++) {
                grid[i][j] = next.charAt(j);
            }
        }
        System.out.println(getCount(grid));
    }

    public static int getCount(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int topRow = 0; topRow < n; topRow++) {
            for (int bottomRow = topRow; bottomRow < n; bottomRow++) {
                for (int leftCol = 0; leftCol < m; leftCol++) {
                    for (int rightCol = leftCol; rightCol < m; rightCol++) {
                        Set<Character> uniqueChars = new HashSet<>();
                        boolean isValidSubmatrix = true;

                        for (int row = topRow; row <= bottomRow; row++) {
                            for (int col = leftCol; col <= rightCol; col++) {
                                char currentChar = grid[row][col];

                                if (uniqueChars.contains(currentChar)) {
                                    isValidSubmatrix = false;
                                    break;
                                }
                                uniqueChars.add(currentChar);
                            }
                            if (!isValidSubmatrix) {
                                break;
                            }
                        }
                        if (isValidSubmatrix) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
