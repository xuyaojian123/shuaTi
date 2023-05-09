package xyj.P103¶þ²æÊ÷µÄ¾â³ÝÐÎ²ãÐò±éÀú;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(20);
        TreeNode treeNode4 = new TreeNode(15);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.zigzagLevelOrder(treeNode1);
        int t = 1;


    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (root==null){
            return results;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int flag = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                layer.add(poll.val);
                if (poll.left!=null){
                    queue.add(poll.left);
                }
                if (poll.right!=null){
                    queue.add(poll.right);
                }
            }
            if (flag%2==1){
                Collections.reverse(layer);
            }
            flag++;
            results.add(layer);
        }
        return results;
    }

}
