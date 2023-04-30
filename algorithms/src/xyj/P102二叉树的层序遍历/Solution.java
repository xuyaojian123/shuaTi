package xyj.P102¶þ²æÊ÷µÄ²ãÐò±éÀú;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);

        while (!pq.isEmpty()){
            int size = pq.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = pq.poll();
                temp.add(curr.val);
                if (curr.left!=null){
                    pq.offer(curr.left);
                }
                if (curr.right!=null){
                    pq.offer(curr.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
