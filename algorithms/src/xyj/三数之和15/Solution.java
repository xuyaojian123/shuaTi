package xyj.����֮��15;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        List<List<Integer>> results = nsum(nums, 0,0,3);
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

    /* �������� nums �����к�Ϊ target ����Ԫ�� */
    //public List<List<Integer>> threeSumTarget(int[] nums, int target) {
    //    int n = nums.length;
    //    List<List<Integer>> res = new ArrayList<>();
    //    // ��� threeSum �ĵ�һ����
    //    for (int i = 0; i < n; i++) {
    //        // �� target - nums[i] ���� twoSum
    //        List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
    //        // ����������������Ķ�Ԫ�飬�ټ��� nums[i] ���ǽ����Ԫ��
    //        for (int j = 0; j < tuples.size(); j++) {
    //            tuples.get(j).add(nums[i]);
    //            res.add(tuples.get(j));
    //            for (int k = 0; k < tuples.get(j).size(); k++) {
    //                System.out.print(tuples.get(j).get(k)+" ");
    //            }
    //            System.out.println();
    //        }
    //        // ������һ�������ظ�����������������ظ����
    //        while (i < n - 1 && nums[i] == nums[i + 1]) i++;
    //    }
    //    return res;
    //}

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

    // ����㷨����ʱ��
    public void combine(int[] nums,int start,int k,List<Integer> temp,List<List<Integer>> result,Map<String,Integer> flag){
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            if (temp.size() == k){
                if (temp.get(0) + temp.get(1) + temp.get(2) ==0){
                    List<Integer> p = new ArrayList<>(temp);
                    Collections.sort(p);
                    String str = " "+p.get(0) + p.get(1) + p.get(2);
                    if (!flag.containsKey(str)){
                        flag.put(str,1);
                        System.out.println(temp.get(0) +" " + temp.get(1) + " " + temp.get(2));
                        result.add(new ArrayList<>(temp));
                    }
                }
                temp.remove(temp.size() -1);
                continue;
            }else {
                combine(nums,i+1,k,temp,result,flag);
                temp.remove(temp.size()-1);
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,0,-1,0,-2,2};
        solution.threeSum(nums);
    }
}
