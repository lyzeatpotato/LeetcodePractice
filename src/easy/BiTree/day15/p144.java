package easy.BiTree.day15;

import easy.BiTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: p144
 * @Description: 二叉树前序遍历
 * @author: lyz
 * @date: 2023 08 2023/8/14 18:53
 */

public class p144 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] s = input.split(" ");
        TreeNode inputTree = getInputTree(s);
        List<Integer> integers = preorderTraversal(inputTree);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        porder(root, resList);
        return resList;
    }

    public static void porder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        porder(root.left, result);
        porder(root.right, result);
    }

    public static TreeNode getInputTree(String[] s) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(s[i]));
                list.add(node);
            } else {
                list.add(null);
            }
        }
        TreeNode root;
        for (int i = 0; i < list.size() / 2 + 1; i++) {//只用遍历到数组长度的一半
            root = list.get(i);//指向当前要进行操作（添加左右子节点）的节点
            if (root != null) {
                if (i * 2 + 1 < list.size()) {
                    TreeNode left = list.get(i * 2 + 1);//添加左子节点
                    root.left = left;
                    if (i * 2 + 2 < list.size()) {//需要判断是否已经添加完毕
                        TreeNode right = list.get(i * 2 + 2);//添加右子节点
                        root.right = right;
                    }
                } else {
                    root.left = list.get(i + 1);
                }
            }
        }
        TreeNode treeNode = list.get(0);
        return treeNode;
    }
}
