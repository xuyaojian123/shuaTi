package xyj.P31下一个排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://www.cnblogs.com/houkai/p/3675270.html
public class Solution {

    //没有重复元素（按照字典序列生成全排列）
    public List<List<Integer>> permutation(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result,nums,0);
        return result;

    }
    public void backtracking(List<List<Integer>> result, int[] nums,int t){
        if (t == nums.length){
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.println();
        }else {
            for (int i = t;i<nums.length;i++){
                //Arrays.sort(nums,t,nums.length);
                swap(nums,t,i);
                backtracking(result,nums,t+1);
                swap(nums,t,i);
            }
        }
    }
    public void swap(int[] nums,int a,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    // 按照字典序列,找到下一个排列
    public void nextPermutation(int[] nums) {
        int ans = 0,sym=0;
        int flag = 0;
        for (int i = nums.length-1; i >=1; i--) {
            if (nums[i] > nums[i-1]){
                ans = i-1;
                sym=1;
                break;
            }
        }
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i] > nums[ans]){
                flag = i;
                break;
            }
        }
        swap(nums,ans,flag);
        if (sym == 0){
            ans = -1;
        }
        Arrays.sort(nums, ans+1,nums.length);
    }

    public static void main(String[] args) {
        //int[] nums = {1,2,3,4,5};
        //int[] nums = {3,2,1};
        int[] nums = {1,2,3} ;
        Solution solution = new Solution();
        solution.permutation(nums);
        solution.nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}
