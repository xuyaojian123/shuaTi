package xyj.在排序数组中查找元素的第一个和最后一个位置34;

public class Solution {


    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[]{-1,-1};
        int left = 0,right = nums.length - 1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] < target){
                left = mid+1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                int ans1 = mid,ans2 = mid;
                while (ans1 >=0  && nums[ans1] == nums[mid] ){
                    ans1 --;
                }
                while (ans2 < nums.length  &&nums[ans2] == nums[mid]){
                    ans2++;
                }
                pos[0] = ans1+1;pos[1] = ans2-1;
                break;
            }
        }
        return pos;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1};
        int[] ints1 = solution.searchRange(ints, 1);
        System.out.println(ints1[0]+","+ints1[1]);

    }
}


