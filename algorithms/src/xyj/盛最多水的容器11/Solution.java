package xyj.盛最多水的容器11;


public class Solution {

    public int maxArea(int[] height) {
        int n = height.length;
        int left =0,right = n-1;
        int maxArea = -1;
        while (left<right){
            int area = (right - left)*Math.min(height[left],height[right]);
            if (area>maxArea){
                maxArea = area;
            }
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] ints = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        int i = solution.maxArea(ints);
        System.out.println(i);
    }
}
