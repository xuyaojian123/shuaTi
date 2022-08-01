package xyj.����ܺ�40;

import java.util.*;
// д����������
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
        //�����һ�����ֿ�ʼ��ǰ
        //dfs(pos + 1, rest);
        int most = Math.min(rest / freq.get(pos)[0], freq.get(pos)[1]);
        for (int i = 1; i <= most; ++i) {
            sequence.add(freq.get(pos)[0]);
            dfs(pos + 1, rest - i * freq.get(pos)[0]);
        }
        for (int i = 1; i <= most; ++i) {
            sequence.remove(sequence.size() - 1);
        }
        //�ӵ�һ����������
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
        // ��������ʱ��������ά�ȣ�һ����һֱ���µ�ά�ȣ�һ����ͬһ��ά�ȡ�������ĿҪ����ͬһ��ά���в��ܳ����ظ�����
        for (int i = idx; i < candidates.length;++i) {
            // ����ܹؼ�Ҳ�������:ͬһ�㲻�ܳ�����ͬԪ��
            if (i>idx && candidates[i] == candidates[i-1]){
                continue;
            }
            // ѡ��ǰԪ��
            combine.add(candidates[i]);
            dfs2(candidates,result,combine,target - candidates[i],i+1);
            //��ѡ��ǰԪ��
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
