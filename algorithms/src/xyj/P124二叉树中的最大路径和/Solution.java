package xyj.P124�������е����·����;

public class Solution {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     * ���ؾ���root�ĵ��߷�֧���ͣ� ��Math.max(root, root+left, root+right)
     * @param root
     * @return
     */
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //������߷�֧���ֵ����߷�֧���Ϊ���������粻ѡ��
        int leftMax = Math.max(0, dfs(root.left));
        //�����ұ߷�֧���ֵ���ұ߷�֧���Ϊ���������粻ѡ��
        int rightMax = Math.max(0, dfs(root.right));
        //left->root->right ��Ϊ·�����Ѿ��������ʷ���ֵ���Ƚ�
        max = Math.max(max, root.val + leftMax + rightMax);
        // ���ؾ���root�ĵ�������֧����ǰroot�ĸ��ڵ����ʹ��
        return root.val + Math.max(leftMax, rightMax);
    }

}
