package xyj.P94二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        List<Integer> integers = solution.inorderTraversal(root);
        int t = 1;


    }


    //二叉树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res);
        return res;
    }

    private void  traverse(TreeNode node,List<Integer> result){
        if (node==null){
            return;
        }
        result.add(node.val);
        traverse(node.left,result);
        traverse(node.right,result);

    }
}

