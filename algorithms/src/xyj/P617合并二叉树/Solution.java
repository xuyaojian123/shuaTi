package xyj.P617合并二叉树;

public class Solution {


    //两个二叉树的对应节点可能存在以下三种情况，对于每种情况使用不同的合并方式。

    //如果两个二叉树的对应节点都为空，则合并后的二叉树的对应节点也为空；
    //
    //如果两个二叉树的对应节点只有一个为空，则合并后的二叉树的对应节点为其中的非空节点；
    //
    //如果两个二叉树的对应节点都不为空，则合并后的二叉树的对应节点的值为两个二叉树的对应节点的值之和，此时需要显性合并两个节点。

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) {
            return root1==null? root2 : root1;
        }
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }

    // 方法二：不创建新的节点
    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，只要有一个是null，函数就直接返回
        if(r1==null || r2==null) {
            return r1==null? r2 : r1;
        }
        //让r1的值 等于  r1和r2的值累加，再递归的计算两颗树的左节点、右节点
        r1.val += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }

}
