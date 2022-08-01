package xyj.组合总和40;

import java.util.*;
// 写了两种做法
public class Solution {


    List<int[]> freq = new ArrayList<int[]>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    List<Integer> sequence = new ArrayList<Integer>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        for (int num : candidates) {
            int size = freq.size();
            if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                freq.add(new int[]{num, 1});
            } else {
                ++freq.get(size - 1)[1];
            }
        }
        dfs(0, target);
        return ans;
    }

    public void dfs(int pos, int rest) {
        if (rest == 0) {
            ans.add(new ArrayList<Integer>(sequence));
            return;
        }
        if (pos == freq.size() || rest < freq.get(pos)[0]) {
            return;
        }
        //从最后一个数字开始往前
        //dfs(pos + 1, rest);
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
        //从第一个数字往后
        dfs(pos + 1, rest);
    }


    public List<List<Integer>> combinationSum2_two(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        //boolean[] used = new boolean[candidates.length];
        dfs2(candidates,result,combine,target,0);
        return result;

    }

    public void dfs2(int[] candidates,List<List<Integer>> result,List<Integer> combine,int target,int idx){
        if (target == 0){
            result.add(new ArrayList<>(combine));
            return;
        }
        if (target <0 || idx>=candidates.length){
            return;
        }
        // 遍历树的时候有两个维度，一个是一直向下的维度，一个是同一层维度。根据题目要求在同一层维度中不能出现重复数字
        for (int i = idx; i < candidates.length;++i) {
            // 这里很关键也很难理解:同一层不能出现相同元素
            if (i>idx && candidates[i] == candidates[i-1]){
                continue;
            }
            // 选择当前元素
            combine.add(candidates[i]);
            dfs2(candidates,result,combine,target - candidates[i],i+1);
            //不选择当前元素
            combine.remove(combine.size()-1);
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {1,2};
        int target = 2;
        System.out.println(candidates.length);
        solution.combinationSum2_two(candidates,target);
    }
}
