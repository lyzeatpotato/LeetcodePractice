package SHEIN;

import java.util.Scanner;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/23 13:28
 */

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] requests = new int[n][2];
        for (int i = 0; i < n; i++) {
            requests[i][0] = scan.nextInt();
            requests[i][1] = scan.nextInt();
        }
        System.out.println(getConstrainCount(requests));
    }

    public static int getConstrainCount(int[][] requests) {
        int bucket = 100;   //初始状态下令牌桶有100个令牌
        int constrainedNum = 0;
        for (int i = 0; i < requests.length; i++) {
            if (i > 0) {
                bucket = bucket + ((requests[i][0] - requests[i - 1][0])/100) * 10 > 150 ? 150 : bucket + ((requests[i][0] - requests[i - 1][0])/100) * 10;
            } else {
                bucket = bucket + (requests[i][0]/100) * 10 > 150 ? 150 : bucket + (requests[i][0]/100) * 10;
            }
            if (requests[i][1] <= bucket) {
                bucket -= requests[i][1];
            } else {
                constrainedNum += requests[i][1] - bucket;
                bucket = 0;
            }
        }
        return constrainedNum;
    }
}
