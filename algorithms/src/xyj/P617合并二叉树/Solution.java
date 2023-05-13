package xyj.P617�ϲ�������;

public class Solution {


    //�����������Ķ�Ӧ�ڵ���ܴ��������������������ÿ�����ʹ�ò�ͬ�ĺϲ���ʽ��

    //��������������Ķ�Ӧ�ڵ㶼Ϊ�գ���ϲ���Ķ������Ķ�Ӧ�ڵ�ҲΪ�գ�
    //
    //��������������Ķ�Ӧ�ڵ�ֻ��һ��Ϊ�գ���ϲ���Ķ������Ķ�Ӧ�ڵ�Ϊ���еķǿսڵ㣻
    //
    //��������������Ķ�Ӧ�ڵ㶼��Ϊ�գ���ϲ���Ķ������Ķ�Ӧ�ڵ��ֵΪ�����������Ķ�Ӧ�ڵ��ֵ֮�ͣ���ʱ��Ҫ���Ժϲ������ڵ㡣

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) {
            return root1==null? root2 : root1;
        }
        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }

    // ���������������µĽڵ�
    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // ��� r1��r2�У�ֻҪ��һ����null��������ֱ�ӷ���
        if(r1==null || r2==null) {
            return r1==null? r2 : r1;
        }
        //��r1��ֵ ����  r1��r2��ֵ�ۼӣ��ٵݹ�ļ�������������ڵ㡢�ҽڵ�
        r1.val += r2.val;
        r1.left = dfs(r1.left,r2.left);
        r1.right = dfs(r1.right,r2.right);
        return r1;
    }

}
