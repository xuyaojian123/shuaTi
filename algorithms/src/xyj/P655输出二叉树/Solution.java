package xyj.P655Êä³ö¶þ²æÊ÷;

import java.util.ArrayList;
import java.util.List;

public class Solution {



    List<List<String>> res = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        dfs(root,1);
        int n = 0;
        for (int i = 0; i < res.size(); i++) {
            n = (int) Math.pow(2, res.size())+ 1;
            for (int j = 0; j < n; j++) {
                res.get(i).add("");
            }
        }
        dfs1(root,0,(n-1)/2);
        return null;

    }

    public void dfs(TreeNode root, int curHeight){
        if (root == null){
            return;
        }
        if (curHeight > res.size()){
            List<String> layer = new ArrayList<>();
            res.add(layer);
        }
        dfs(root.left, curHeight+1);
        dfs(root.right, curHeight+1);
    }

    public void dfs1(TreeNode root, int i, int j){
        if (root == null){
            return;
        }
        res.get(i).set(j,String.valueOf(root.val));
        int a = (int)Math.pow(2,res.size()-i-2);
        dfs1(root.left, i+1,j-a);
        dfs1(root.right, i+1,j+a);
    }
}
