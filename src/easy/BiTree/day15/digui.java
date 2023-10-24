package easy.BiTree.day15;

import easy.BiTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class digui {

    public static void main(String[] args) {
        //初始化数据
        ArrayList<String> nums = new ArrayList<>();
        System.out.print("请输入树的总结点数:");
        Scanner inn = new Scanner(System.in);
        int sum = inn.nextInt();
        int i = 0;
        System.out.print("请输入树的所有结点:");

        while(i != sum) {
            Scanner in = new Scanner(System.in);
            //输入文字
            String strs = in.nextLine();
            nums.add(strs);
            i++;
        }
        //实例化对象
        digui tree = new digui();

        //创建二叉树，并将根节点（root）保存
        TreeNode root = tree.createTree(nums);
        //前序遍历（递归）
        System.out.println("前序遍历：");
        PreOrder(root);
        System.out.println();
        //中序遍历
        System.out.println("中序遍历：");
        MiddleOrder(root);
        System.out.println();
        //后序遍历
        System.out.println("前序遍历：");
        PostOrder(root);
    }

    //前序遍历
    private static void PreOrder(TreeNode root) {
        if (root != null) {
            System.out.printf(root.val+"\t");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }


    //中序遍历
    private static void MiddleOrder(TreeNode root) {
        if (root != null) {
            MiddleOrder(root.left);
            System.out.printf(root.val+"\t");
            MiddleOrder(root.right);
        }
    }

    //后序遍历
    private static void PostOrder(TreeNode root) {
        if (root != null) {
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.printf(root.val+"\t");
        }
    }

    private static TreeNode createTree(ArrayList<String> nums) {
        List<TreeNode> list = new ArrayList<>();//将元素（int）保存到TreeNode中，直接对元素(Treenood(int))进行树创建的操作
        for (int i = 0;i<nums.size();i++) {
            if(!nums.get(i).equals("null")) {
                TreeNode node = new TreeNode(Integer.parseInt(nums.get(i)));
                list.add(node);
            }else{
                list.add(null);
            }
        }
        TreeNode root;
        for (int i = 0;i<list.size()/2;i++) {//只用遍历到数组长度的一半
            root = list.get(i);//指向当前要进行操作（添加左右子节点）的节点
            if(root != null) {
                TreeNode left = list.get(i * 2 + 1);//添加左子节点
                root.left = left;
                if (i * 2 + 2 < list.size()) {//需要判断是否已经添加完毕
                    TreeNode right = list.get(i * 2 + 2);//添加右子节点
                    root.right = right;
                }
            }
        }
        return list.get(0);//返回根节点（因为二叉树是从List的第0个元素开始，即0处的元素为根节点）
    }
}


