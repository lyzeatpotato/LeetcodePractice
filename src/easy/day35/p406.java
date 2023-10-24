package easy.day35;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName: p406
 * @Description: 根据身高重建队列
 * @author: lyz
 * @date: 2023 08 2023/8/29 10:29
 */

public class p406 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //按照每行两个 空格分隔输入
        int n = scan.nextInt();
        scan.nextLine();
        int[][] people = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = scan.nextLine();
            String[] input = s.split(" ");
            people[i] = new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
        }
        int[][] result = reconstructQueue(people);
        System.out.println(result);
    }

    public static int[][] reconstructQueue(int[][] people) {
        //1.先对数组按照身高h递减排列
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j][0] < people[j+1][0]) {
                    int[] temp = people[j+1];
                    people[j+1] = people[j];
                    people[j] = temp;
                } else if (people[j][0] == people[j+1][0]) {
                    //身高相同则按照k递增排列
                    if (people[j][1] > people[j+1][1]) {
                        int[] temp2 = people[j+1];
                        people[j+1] = people[j];
                        people[j] = temp2;
                    }
                }
            }
        }

        //2.根据重新得到的数组依次按照需求插入
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i][1], people[i]);
        }

        //3.将链表转换成二维数组返回
        return queue.toArray(new int[people.length][]);
    }
}
