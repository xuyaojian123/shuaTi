package xyj.寻找两个正序数组的中位数4;

// 只想到暴力实现，使用归并排序，合并两个数组，然后找到中间的位置
public class Solution {

    public int[]  merge(int[] a,int[] b){
        int[] result = new int[a.length + b.length];
        int l1=a.length,l2 = b.length;
        int i = 0,j = 0;
        int k = 0;
        // 第一步
        while ( i< l1 && j< l2){
            if (a[i] < b[j] ){
                result[k++] = a[i++];
            }else if( a[i] > b[j] ){
                result[k++] = b[j++];
            }else if( a[i] == b[j] ){
                result[k++] = a[i++];
                result[k++] = b[j++];
            }
        }
        //第二步
        while ( i < l1 ){
            result[k++] = a[i++];
        }
        //第三步
        while ( j < l2 ){
            result[k++] = b[j++];
        }
        return result;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = merge(nums1, nums2);
        int mid = merge.length / 2;
        if(merge.length%2 == 0){
            return (merge[mid-1] + merge[mid])/2.0;
        }else {
            return merge[mid];
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
}
