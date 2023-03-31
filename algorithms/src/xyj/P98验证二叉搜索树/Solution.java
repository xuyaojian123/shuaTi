package xyj.P98验证二叉搜索树;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(7);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(8);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = root4;
        root2.left = root5;
        root2.right = root6;
        boolean validBST_2 = solution.isValidBST_2(root);
        int p = 1;
    }



    // 二叉搜索树
    //若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
    //若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
    //任意节点的左、右子树也分别为二叉查找树；
    //没有键值相等的节点
    public boolean isValidBST(TreeNode root) {
        boolean check = check(root);
        return check;
    }


    public boolean isValidBST_2(TreeNode root) {
        return validBST_3(Long.MIN_VALUE, Long.MAX_VALUE, root);
    }

    private boolean validBST_3(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        boolean left = validBST_3(lower, root.val, root.left);
        boolean right = validBST_3(root.val, upper, root.right);
        return left && right;
    }

    // 剪枝
    private boolean validBST_3_1(long lower, long upper, TreeNode root) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return validBST_3_1(lower, root.val, root.left) && validBST_3_1(root.val, upper, root.right);
    }


    // 递归判断是否为合法的二叉搜索树
    // 记录上一个节点node
    private TreeNode pre_node;
    private boolean check(TreeNode node){
        if (node == null) return true;
        boolean left = check(node.left);
        if (pre_node!=null && pre_node.val >= node.val){
            return false;
        }
        pre_node = node;
        boolean right = check(node.right);
        return left && right;
    }



    // 中序遍历，把结果存放到list当中，判断list是否为有序
    public boolean isValidBST_1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inOrder(root, list);
        for (int i = 0; i < list.size() - 1; ++i) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }
        return true;
    }


    public void inOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
