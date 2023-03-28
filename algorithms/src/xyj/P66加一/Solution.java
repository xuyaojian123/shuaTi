package xyj.P66¼ÓÒ»;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {8,9,9,9};
        int[] ints = solution.plusOne(nums);
        int a = 1;

    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] = (digits[len-1] + 1)%10;
        int flag = 0;
        if (digits[len-1]==0){
            flag = 1;
        }
        for (int i = len-2; i >=0; i--) {
            digits[i] = digits[i] + flag;
            if(digits[i] == 10){
                flag = 1;
                digits[i] = 0;
            }else {
                flag = 0;
                break;
            }
        }
        if (flag==1){
            int[] ans = new int[len + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
