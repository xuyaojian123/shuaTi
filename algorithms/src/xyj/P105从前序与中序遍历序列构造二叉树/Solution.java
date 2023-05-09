package xyj.P105从前序与中序遍历序列构造二叉树;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(new int[]{1}, new int[]{1});

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构造哈希映射，帮助我们快速定位根节点
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildMyTree(preorder, inorder,0,n-1,0,n-1, indexMap);
        return root;
    }

    public TreeNode buildMyTree(int[] preorder, int[] inorder,int preorder_left, int preorder_right, int inorder_left, int inorder_right, Map<Integer,Integer> indexMap) {
        if (preorder_left > preorder_right){
            return null;
        }
        int value = preorder[preorder_left];
        int index = indexMap.get(value);
        TreeNode root = new TreeNode(value);

        // 得到左子树中的节点数目
        int size_left_subtree = index - inorder_left;
        root.left = buildMyTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, index - 1, indexMap);
        root.right = buildMyTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, index+1, inorder_right, indexMap);
        return root;
    }


    //public TreeNode buildTree(int[] preorder, int[] inorder) {
    //    if (preorder.length== 0 || inorder.length==0){
    //        return null;
    //    }
    //    int value = preorder[0];
    //    TreeNode root = new TreeNode(value);
    //    for (int i = 0; i < inorder.length; i++) {
    //        if (value == inorder[i]){
    //            // 找左子树的中序遍历
    //            int[] left_ino = Arrays.copyOfRange(inorder, 0, i);
    //            int left_len = left_ino.length;
    //            // 找左子树的前序遍历
    //            int[] left_pre = Arrays.copyOfRange(preorder,1,1 + left_len);
    //            // 找右子树的中序遍历
    //            int[] right_ino = Arrays.copyOfRange(inorder, i+1, inorder.length);
    //            // 找右子树的前序遍历
    //            int[] right_pre = Arrays.copyOfRange(preorder,1 + left_len,inorder.length);
    //            root.left = buildTree(left_pre, left_ino);
    //            root.right = buildTree(right_pre, right_ino);
    //            break;
    //        }
    //    }
    //    return root;
    //}
}
