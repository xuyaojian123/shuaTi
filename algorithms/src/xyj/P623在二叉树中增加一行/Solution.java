package xyj.P623在二叉树中增加一行;

public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth==1){
            root = new TreeNode(val,root,null);
        }else {
            root = dfs(root, 1, depth, val);
        }
        return root;
    }

    public TreeNode dfs(TreeNode root, int curHeight,int depth,int val){
        if (root==null){
            return null;
        }
        if (curHeight == depth-1){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val,null,root.right);
        }else {
            root.left = dfs(root.left,curHeight+1,depth,val);
            root.right = dfs(root.right,curHeight+1,depth,val);
        }
        return root;
    }
}
