package easy.day001;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.PriorityQueue;

/**
 * @ClassName: p2530
 * @Description:
 * @author: lyz
 * @date: 2023 10 2023/10/18 9:07
 */

public class p2530 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 10,3, 3,3};
        int k = 3;
        System.out.println(maxKelements(nums, k));
    }

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b) -> b-a);
        for (int num : nums) {
            priorityQueue.add(num);
        }
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int top = priorityQueue.poll();
            sum += top;
            priorityQueue.offer(ceil(top));
        }
        return sum;
    }

    public static int ceil(int val) {
        if (val % 3 == 0) {
            return val / 3;
        } else {
            return val / 3 + 1;
        }
    }
}
