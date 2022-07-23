package xyj.删除有序数组中的重复项26;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int flag = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[flag] = nums[i];
                flag++;
            }
        }
       return flag;
    }

    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        //int[] a = {0,1,2,2};
        Solution solution = new Solution();
        int i = solution.removeDuplicates(a);
        System.out.println(i);

    }
}
