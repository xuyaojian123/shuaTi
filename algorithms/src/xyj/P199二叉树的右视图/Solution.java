package xyj.P199¶þ²æÊ÷µÄÓÒÊÓÍ¼;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    //public List<Integer> rightSideView(TreeNode root) {
    //    dfs1(root);
    //    dfs2(root);
    //    List<Integer> result = new ArrayList<>();
    //    for (int i = a.size()-1; i >=0; i--) {
    //        result.add(a.get(i));
    //        if (a.get(i).intValue() == b.get(0).intValue()){
    //            break;
    //        }
    //    }
    //    return result;
    //}
    //
    //List<Integer> a = new ArrayList<Integer>();
    //List<Integer> b = new ArrayList<Integer>();
    //
    //public void dfs1(TreeNode root){
    //    if (root==null){
    //        return;
    //    }
    //    dfs1(root.left);
    //    dfs1(root.right);
    //    a.add(root.val);
    //}
    //
    //public void dfs2(TreeNode root){
    //    if (root==null){
    //        return;
    //    }
    //    dfs1(root.right);
    //    dfs1(root.left);
    //    b.add(root.val);
    //}
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,1);
        return res;
    }

    List<Integer> res = new ArrayList<Integer>();

    public void dfs(TreeNode root, int height){
        if (root == null){
            return;
        }
        if (height > res.size()){
            res.add(root.val);
        }
        dfs(root.right, height+1);
        dfs(root.left, height+1);
    }
}
