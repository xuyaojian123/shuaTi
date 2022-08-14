package xyj.跳跃游戏II45;

import sun.security.krb5.Asn1Exception;
import xyj.通配符匹配44.Main;

import java.util.LinkedList;

public class Solution {
    public int jump(int[] nums) {
        int L = nums.length;
        int step = 0;
        int pos = 0;
        while (pos < L - 1){
            System.out.println(pos);
            int ans = pos + nums[pos];
            if (ans >= L-1 ){
                step++;
                break;
            }else {
                int max = Integer.MIN_VALUE;
                for (int i = pos + 1; i <= ans ; i++) {
                    if ( i+nums[i] > max ){
                        max = i+nums[i];
                        // 跳到最远的下标
                        pos = i;
                    }
                }
                step++;
            }
        }
        return step;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
        int jump = solution.jump(nums);
        System.out.println(jump);

    }
}
