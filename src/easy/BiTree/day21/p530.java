package easy.BiTree.day21;

import easy.BiTree.TreeNode;
import easy.BiTree.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: p530
 * @Description: 二叉搜索树的最小绝对差
 * @author: lyz
 * @date: 2023 08 2023/8/16 18:32
 */

public class p530 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] s = input.split(" ");
        TreeNode root = Utils.getInputTree(s);

        int minimumDifference = getMinimumDifference(root);
        System.out.println(minimumDifference);
    }

    public static int getMinimumDifference(TreeNode root) {
        //1.先将原始二叉树转化成中序遍历的数组
        List<Integer> list = new ArrayList<>();
        porder(root, list);
        int[] nums = list.stream().mapToInt(e -> e).toArray();

        //2.对转换后的数组求最小差的绝对值
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int abs = Math.abs(nums[0] - nums[1]);
            if (abs < result) {
                result = abs;
            }
        }
        return result;
    }

    public static void porder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        porder(root.left, list);
        list.add(root.val);
        porder(root.right, list);
    }
}
