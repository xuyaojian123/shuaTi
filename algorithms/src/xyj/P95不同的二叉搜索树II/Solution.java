package xyj.P95不同的二叉搜索树II;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //TreeNode binaryTree = solution.createBinaryTree(3);
        List<TreeNode> treeNodes = solution.generateTrees(3);
        int t = 1;

    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = helper_all(1, n);
        return treeNodes;
    }


    public TreeNode createBinaryTree(int n){
        return helper(1, n);
    }


    // 构建一颗二叉搜索树
    public TreeNode helper(int start, int end){
        if(start > end)
            return null;

        // 这里可以选择从start到end的任何一个值做为根结点，
        // 这里选择它们的中点，实际上，这样构建出来的是一颗平衡二叉搜索树
        int val = (start + end) / 2;
        TreeNode root = new TreeNode(val);

        root.left = helper(start, val - 1);
        root.right = helper(val + 1, end);

        return root;
    }

    // 构建搜索情况的二叉搜索树
    public List<TreeNode> helper_all(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            //为什么加null，如果一颗树的左子树为空，右子树不为空，要正确构建所有树，依赖于对左右子树列表的遍历，
            // 也就是上述代码两层for循环的地方，如果其中一个列表为空，那么循环都将无法进行。
            list.add(null);
            return list;
        }
        // 枚举可行根节点
        for (int i = start; i <= end; i++) {
            // 获得所有可行的左子树集合
            List<TreeNode> left = helper_all(start, i - 1);
            // 获得所有可行的右子树集合
            List<TreeNode> right = helper_all(i + 1, end);

            // 从左子树集合中选出一棵左子树，从右子树集合中选出一棵右子树，拼接到根节点上
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left.get(j);
                    treeNode.right = right.get(k);
                    list.add(treeNode);
                }
            }
        }
        return list;
    }

}
