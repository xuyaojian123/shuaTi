package xyj.ÌøÔ¾ÓÎÏ·55;

public class Solution {

    public static void main(String[] args) {

    }


    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        int max_index = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (i <= max_index){
                max_index = Math.max(max_index, i + nums[i]);
                if (max_index >= nums.length-1){
                    return true;
                }
            }
        }
        return false;

    }
}
