package easy.BiTree.day21;

import easy.BiTree.TreeNode;
import easy.BiTree.Utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: p501
 * @Description: 返回二叉搜索树中的众数
 * @author: lyz
 * @date: 2023 08 2023/8/16 19:14
 */

public class p501 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] s = input.split(" ");
        TreeNode root = Utils.getInputTree(s);

        int[] mode = findMode(root);
        for (int element : mode) {
            System.out.println(element);
        }
    }

    public static int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        porder(root, list);
        int[] nums = list.stream().mapToInt(e -> e).toArray();

        //统计数组中重复出现的元素
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<Map.Entry<Integer, Integer>> sorted = map.entrySet().stream()
                .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .collect(Collectors.toList());
        List<Integer> resultList = new ArrayList<>();
        resultList.add(sorted.get(0).getKey());
        for (int i = 1; i < sorted.size(); i++) {
            if (sorted.get(i).getValue() == sorted.get(i - 1).getValue()) {
                resultList.add(sorted.get(i).getValue());
            } else {
                break;
            }
        }
        return resultList.stream().mapToInt(e -> e).toArray();
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
