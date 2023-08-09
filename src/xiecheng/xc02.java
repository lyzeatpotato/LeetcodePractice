package xiecheng;

import java.util.Scanner;

public class xc02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                boolean hasY = false;
                boolean hasO = false;
                boolean hasU = false;
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        char c = matrix[i+k][j+l];
                        if (c == 'y') {
                            hasY = true;
                        } else if (c == 'o') {
                            hasO = true;
                        } else if (c == 'u') {
                            hasU = true;
                        }
                    }
                }
                if (hasY && hasO && hasU) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}