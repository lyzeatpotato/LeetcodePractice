package easy.BiTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Utils
 * @Description: 二叉树输入输出工具类
 * @author: lyz
 * @date: 2023 08 2023/8/16 18:43
 */

public class Utils {
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
                }
            }
        }
        TreeNode treeNode = list.get(0);
        return treeNode;
    }
}
