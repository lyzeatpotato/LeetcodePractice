package easy.BiTree;

/**
 * @ClassName: TreeNode
 * @Description: 树 数据结构
 * @author: lyz
 * @date: 2023 08 2023/8/9 11:53
 */

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
