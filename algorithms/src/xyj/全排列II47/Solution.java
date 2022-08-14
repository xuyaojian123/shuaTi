package xyj.全排列II47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://blog.csdn.net/u013309870/article/details/68941284
public class Solution {
    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i]){
                continue;
            }
            // 同一树层重复元素只能使用一次
            if (i>0 &&  nums[i] == nums[i-1] && vis[i-1]==false){
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

    public void swap(int[] nums,int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1} ;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(nums);

    }
}
