package xyj.P77组合;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        int a = 1;
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> com = new ArrayList<>();
        //dfs(result,n,k,1,com);
        dfs2(n,k,1,com,result);
        return result;
    }
    
    
    public void dfs(List<List<Integer>> result, int n, int k, int t, List<Integer> com){
        if (com.size() == k){
            result.add(new ArrayList<>(com));
            return;
        }
        if (t>n){
            return;
        }
        com.add(t);
        dfs(result,n,k,t+1,com);
        com.remove(com.size()-1);
        dfs(result,n,k,t+1,com);
    }

    // 第二章种dfs版本(剪枝从i<=n 改为i <=  n - (k - path.size()) + 1)
    public void dfs2(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <=  n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs2(n, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}

