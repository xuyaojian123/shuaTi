package xyj.ÒÆ³ıÔªËØ27;

public class Solution {

    public int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[flag] = nums[i];
                flag++;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

    }
}
