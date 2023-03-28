package xyj.P60排列序列;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int count = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        //String permutation = solution.getPermutation(3, 5);
        //System.out.println(permutation);

        // dfs求全排列
        int[] nums = {1, 2, 3};
        int[] visited = new int[nums.length];
        List<List<Integer>> results = new ArrayList<>();
        solution.dfs(nums,visited,new ArrayList<Integer>(),results);
        int t = 1;

    }

    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = (char) ('1' + i);
        }
        List<String> result = new ArrayList<>();
        perm(chars, 0, n, k, result);
        return result.get(result.size() - 1);
    }

    public void swap(int i, int j, char[] chars) {
        char aChar = chars[i];
        chars[i] = chars[j];
        chars[j] = aChar;
    }

    public void perm(char[] origin, int i, int n, int k, List<String> result) {
        if (result.size() == k) {
            return;
        }
        if (i == n) {
            result.add(String.valueOf(origin));
            return;
        }
        for (int j = i; j < n; j++) {
            Arrays.sort(origin, i, origin.length);  // 保证按照字典序列，从小到大
            swap(i, j, origin);
            perm(origin, i + 1, n, k, result);
            swap(i, j, origin);
        }
    }


    // 全排列dfs
    private void dfs(int[] nums,int[] visited,List<Integer> permutation,List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]==1) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = 1;
            dfs(nums, visited, permutation, results);
            visited[i] = 0;
            permutation.remove(permutation.size() - 1);
        }
    }
}
