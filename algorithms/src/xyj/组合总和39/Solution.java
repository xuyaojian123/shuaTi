package xyj.组合总和39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(target,combine,candidates,result,0);
        return result;
    }


    public void dfs(int target, List<Integer> combine,int[] candidates,List<List<Integer>> result,int idx){

        if (target < 0 || idx >= candidates.length){
            return;
        } else if (target == 0){
            result.add(new ArrayList<>(combine));
        }else {
            if (target < candidates[idx]){
                return;
            }
            // 有两种选择：一、选择当前idx的元素 二、跳过当前idx的元素
            combine.add(candidates[idx]);
            dfs(target - candidates[idx],combine,candidates,result,idx);
            combine.remove(combine.size()-1);
            dfs(target,combine,candidates,result,idx+1);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = new int[]{2};
        int target = 1;
        solution.combinationSum(candidates,target);

    }
}
