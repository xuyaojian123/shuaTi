package xyj.P78子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3});
        int a = 1;
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            List<Integer> com = new ArrayList<>();
            dfs(nums,i,0,com,result);
        }
        return result;
    }

    public void dfs(int[] nums, int k, int start, List<Integer> path, List<List<Integer>> res){
        if (path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < nums.length - (k - path.size()) + 1; i++) {
            path.add(nums[i]);
            dfs(nums, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }


    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    // 第二种dfs
    public void dfs2(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs2(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs2(cur + 1, nums);
    }

    // 第三种dfs
    public void subsetHelper(List<List<Integer>> results, ArrayList<Integer> path, int [] nums, int pos){
        results.add(new ArrayList<>(path));

        for (int i = pos; i< nums.length; i++) {
            path.add(nums[i]);
            subsetHelper(results, path, nums, i+1);
            path.remove(path.size()-1);
        }
    }

}
