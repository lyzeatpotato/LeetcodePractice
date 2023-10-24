package easy.BiTree.day16;

import easy.BiTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: p102
 * @Description: 二叉树的层序遍历
 * @author: lyz
 * @date: 2023 08 2023/8/15 11:04
 */

public class p102 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] s = input.split(" ");
        TreeNode root = getTreeNode(s);
        List<List<Integer>> lists = levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    public static TreeNode getTreeNode(String[] s) {
        //将输入的字符串数组转换成TreeNode
        //1.将所有输入的信息以树节点形式保存在List当中
        List<TreeNode> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            if (!s[i].equals("null")) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(s[i]));
                list.add(treeNode);
            } else {
                list.add(null);
            }
        }
        //2.遍历节点list将信息接在root节点上
        TreeNode root;
        for (int i = 0; i < list.size() / 2 + 1; i++) {
            root = list.get(i);
            if (root != null) {
                if (i * 2 + 1 < list.size()) {
                    //添加左节点
                    TreeNode left = list.get(i * 2 + 1);
                    root.left = left;
                    if (i * 2 + 2 < list.size()) {
                        //添加右节点
                        TreeNode right = list.get(i * 2 + 2);
                        root.right = right;
                    }
                } else {
                    root.left = list.get(i + 1);
                }
            }
        }
        return list.get(0);
    }
}
