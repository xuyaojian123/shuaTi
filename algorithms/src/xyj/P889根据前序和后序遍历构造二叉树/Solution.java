package xyj.P889根据前序和后序遍历构造二叉树;

import java.util.HashMap;

public class Solution {


    public static void main(String[] args) {

        Solution solution = new Solution();
        TreeNode root = solution.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});


    }

    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(postorder[i], i);
        }
        TreeNode root = buildMyTree(preorder, postorder, 0, n - 1, 0, n - 1);
        return root;
    }


    private TreeNode buildMyTree(int[] preorder, int[] postorder, int left_pre, int right_pre, int left_post, int right_post){

        if (left_pre > right_pre){
            return null;
        }

        int value = preorder[left_pre];
        TreeNode root = new TreeNode(value);
        // 防止出界
        //if (left_pre == right_pre){
        //    return root;
        //}
        if (left_post == right_post){
            return root;
        }

        // 左子树的长度
        int sizeL = indexMap.get(preorder[left_pre + 1]) - left_post + 1;

        root.left = buildMyTree(preorder,postorder,left_pre+1, left_pre + sizeL, left_post, left_post + sizeL - 1);
        root.right = buildMyTree(preorder,postorder,left_pre + sizeL + 1, right_pre, left_post + sizeL, right_post - 1);
        return root;
    }
}
