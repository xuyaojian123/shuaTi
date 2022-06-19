package xyj.搜索旋转排序数组33;

public class Solution {

    // 两次二分
    public int search(int[] nums, int target) {
        int left =0 ,right = nums.length-1;
        // 处理特殊情况，序列为升序，没有翻转
        if (nums[right] >= nums[left]){
            right++;
        }else {
            while ( right - left > 1 ){
                int mid = (left + right) / 2;
                if ( nums[mid] > nums[left] ){
                    left = mid;
                }else if (nums[mid] < nums[left]){
                    right = mid;
                }
            }
        }
        //right下标为最小值
        if (target >= nums[0]){
            left = 0;right = right-1;
        }else {
            left = right;right = nums.length-1;
        }
        // 使用二分查找
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1};
        int search = solution.search(nums, 1);
        System.out.println(search);
    }
}
