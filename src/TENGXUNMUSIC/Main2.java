package TENGXUNMUSIC;

/**
 * @ClassName: Main2
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/22 19:19
 */

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Main2 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.right = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        t2.left = new TreeNode(4);
        t2.right = new TreeNode(5);
        TreeNode t3 = new TreeNode(6);
        t3.left = new TreeNode(7);
        t3.right = new TreeNode(8);
        TreeNode[] trees = new TreeNode[] {t1, t2, t3};
        System.out.println(cntOfMethods(trees));
    }

    public static int cntOfMethods(TreeNode[] trees) {
        // write code here
        //对于每个tree取其叶子节点的个数
        int n = trees.length;
        int[] leaves = new int[n];
        for (int i = 0; i < n; i++) {
            leaves[i] = getLeavesNodeCount(trees[i]);
        }
        int[] dp = new int[n];
        dp[0] = leaves[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + (n - i) * leaves[i];
        }
        return dp[n - 1];
    }

    public static int getLeavesNodeCount(TreeNode tree) {
        if (tree == null) {
            return 0;
        }
        if (tree.left == null && tree.right == null) {
            return 2;
        }
        return getLeavesNodeCount(tree.left) + getLeavesNodeCount(tree.right);
    }
}
