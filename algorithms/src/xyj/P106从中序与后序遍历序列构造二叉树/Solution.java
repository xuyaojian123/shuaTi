package xyj.P106从中序与后序遍历序列构造二叉树;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

    }


    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        TreeNode root = buildMyTree(inorder, postorder, 0, n - 1, 0, n - 1);
        return root;
    }

    public TreeNode buildMyTree(int[] inorder, int[] postorder, int left_ino, int right_ino, int left_post, int right_post){
        if (left_ino > right_ino){
            return null;
        }
        int value = postorder[right_post];
        int index = indexMap.get(value);

        TreeNode root = new TreeNode(value);

        //求出左子树的长度
        int left_subTree_len = index - left_ino;

        root.left = buildMyTree(inorder, postorder, left_ino, index-1, left_post, left_post + left_subTree_len - 1);
        root.right = buildMyTree(inorder, postorder, index+1, right_ino, left_post + left_subTree_len, right_post-1);
        return root;
    }
}
