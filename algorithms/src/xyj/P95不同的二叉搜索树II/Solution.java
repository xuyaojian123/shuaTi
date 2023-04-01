package xyj.P95��ͬ�Ķ���������II;

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


    // ����һ�Ŷ���������
    public TreeNode helper(int start, int end){
        if(start > end)
            return null;

        // �������ѡ���start��end���κ�һ��ֵ��Ϊ����㣬
        // ����ѡ�����ǵ��е㣬ʵ���ϣ�����������������һ��ƽ�����������
        int val = (start + end) / 2;
        TreeNode root = new TreeNode(val);

        root.left = helper(start, val - 1);
        root.right = helper(val + 1, end);

        return root;
    }

    // ������������Ķ���������
    public List<TreeNode> helper_all(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            //Ϊʲô��null�����һ������������Ϊ�գ���������Ϊ�գ�Ҫ��ȷ�����������������ڶ����������б�ı�����
            // Ҳ����������������forѭ���ĵط����������һ���б�Ϊ�գ���ôѭ�������޷����С�
            list.add(null);
            return list;
        }
        // ö�ٿ��и��ڵ�
        for (int i = start; i <= end; i++) {
            // ������п��е�����������
            List<TreeNode> left = helper_all(start, i - 1);
            // ������п��е�����������
            List<TreeNode> right = helper_all(i + 1, end);

            // ��������������ѡ��һ������������������������ѡ��һ����������ƴ�ӵ����ڵ���
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
