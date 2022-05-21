package xyj.����֮��18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = nsum(nums, 0,target,4);
        return results;

    }

    /* �� nums[start] ��ʼ��������������
     * nums �����к�Ϊ target �Ķ�Ԫ�� */
    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        // ��ָ���Ϊ�� start ��ʼ����������
        int lo = start, hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == left) lo++;
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) hi--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                res.add(temp);
                while (lo < hi && nums[lo] == left) lo++;
                while (lo < hi && nums[hi] == right) hi--;
            }
        }
        return res;
    }

    public List<List<Integer>> nsum(int[] nums,int start,int target,int k){
        List<List<Integer>> res = new ArrayList<>();
        if (k==2){
            return twoSumTarget(nums,start,target);
        }else {
            // �߽�Ϊlen - k
            for (int i = start; i <= nums.length - k; i++) {
                List<List<Integer>> subs = nsum(nums, i + 1, target - nums[i], k - 1);
                for (int j = 0; j < subs.size(); j++) {
                    subs.get(j).add(nums[i]);
                    for (int y = 0; y < subs.get(j).size(); y++) {
                        System.out.print(subs.get(j).get(y)+" ");
                    }
                    System.out.println();
                }
                res.addAll(subs);
                // ������һ�������ظ�����������������ظ����
                while (i < nums.length - k  && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,-1,0,-2,2};
        solution.fourSum(nums,0);
    }
}
