package xyj.P90�Ӽ�II;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //List<List<Integer>> subsets = solution.subsetsWithDup(new int[]{1, 2, 3});
        List<List<Integer>> subsets = solution.subsetsWithDup_1(new int[]{1, 2, 3});
        int a = 1;

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        Arrays.sort(nums);
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
            // ����ܹؼ�Ҳ�������:ͬһ�㲻�ܳ�����ͬԪ��
            if (i>start && nums[i] == nums[i-1]){
                continue;
            }
            path.add(nums[i]);
            dfs(nums, k, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }


    // �ڶ���dfs������Ҫѭ���������Ӽ�
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup_1(int[] nums) {
        // �Ƚ�������
        Arrays.sort(nums);
        backtrack(0, nums);
        return res;
    }

    public void backtrack(int start, int[] nums) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; ++i) {
            // ȥ��
            if (i > start && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            backtrack(i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
