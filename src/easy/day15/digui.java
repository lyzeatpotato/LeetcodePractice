package easy.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: digui
 * @Description: 递归遍历
 * @author: lyz
 * @date: 2023 08 2023/8/9 11:52
 */

public class digui {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();

        List<Integer> integers = preorderTraversal(treeNode);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}
