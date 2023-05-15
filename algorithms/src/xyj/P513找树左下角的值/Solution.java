package xyj.P513找树左下角的值;

import java.util.*;

public class Solution {


    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //ArrayDeque<TreeNode> queue1 = new ArrayDeque<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            result = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode front = queue.poll();
                if (front.left!=null){
                    queue.offer(front.left);
                }
                if (front.right!=null){
                    queue.offer(front.right);
                }
            }
        }
        return result;
    }

    // dfs 记录遍历的高度
//    int curVal = 0;
//    int curHeight = 0;
//
//    public int findBottomLeftValue(TreeNode root) {
//        int curHeight = 0;
//        dfs(root, 0);
//        return curVal;
//    }
//
//    public void dfs(TreeNode root, int height) {
//        if (root == null) {
//            return;
//        }
//        height++;
//        dfs(root.left, height);
//        dfs(root.right, height);
//        if (height > curHeight) {
//            curHeight = height;
//            curVal = root.val;
//        }
//    }
//

}
