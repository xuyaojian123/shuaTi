package xyj.P60≈≈¡––Ú¡–;

import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static int count = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 5);
        System.out.println(permutation);

    }

    public String getPermutation(int n, int k) {
        char[] chars = new char[n];
        for (int i = 0; i < n; i++) {
            chars[i] = (char) ('1' + i);
        }
        List<String> result = new ArrayList<>();
        perm(chars,0,n,k,result);
        return result.get(result.size()-1);
    }

    public void swap(int i , int j, char[] chars){
        char aChar = chars[i];
        chars[i] = chars[j];
        chars[j] = aChar;
    }

    public void perm(char[] origin, int i, int n, int k, List<String> result){
        if (result.size() == k){
            return;
        }
        if (i == n){
            count++;
            result.add(String.valueOf(origin));
        }
        for (int j = i; j < n; j++) {
            Arrays.sort(origin,i,origin.length);
            swap(i,j,origin);
            perm(origin, i+1,n, k, result);
            swap(i,j,origin);
        }
    }
}
