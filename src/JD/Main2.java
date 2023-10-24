package JD;

import javax.xml.bind.annotation.XmlInlineBinaryData;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: DEWU.Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/2 10:34
 */

public class Main2 {
    static class Item implements Comparable<Item> {
        int b;
        int c;

        public Item(int b, int c) {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Item other) {
            return Integer.compare(this.b, other.b);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int itemCount = scan.nextInt();
        int discountCount = scan.nextInt();

        int[] prices = new int[itemCount];
        Item[] discounts = new Item[discountCount];

        for (int i = 0; i < itemCount; i++) {
            prices[i] = scan.nextInt();
        }

        for (int i = 0; i < discountCount; i++) {
            int b = scan.nextInt();
            int c = scan.nextInt();
            discounts[i] = new Item(b, c);
        }

        Arrays.sort(discounts);

        int[] maxDiscounts = new int[discountCount + 1];
        for (int i = discountCount - 1; i >= 0; i--) {
            maxDiscounts[i] = Math.max(maxDiscounts[i - 1], discounts[i].c);
        }

        long totalCost = 0;
        for (int i = 0; i < itemCount; i++) {
            int pos = binarySearch(prices[i], discounts);
            if (pos != -1) {
                totalCost += prices[i] - maxDiscounts[pos];
            } else {
                totalCost += prices[i];
            }
        }
        System.out.println(totalCost);
    }

    public static int binarySearch(int target, Item[] discounts) {
        int left = 0;
        int right = discounts.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (discounts[mid].b <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
