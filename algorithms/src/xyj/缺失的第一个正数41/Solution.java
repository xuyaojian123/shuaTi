package xyj.ȱʧ�ĵ�һ������41;
//�ص㣺 ȱʧ������һ������[1,L+1]֮��
public class Solution {
    public int firstMissingPositive(int[] nums) {
        int L = nums.length;
        for (int i = 0; i < L; i++) {
            if (nums[i]<=0){
                nums[i] = L+1;
            }
        }
        for (int i = 0; i < L; i++) {
            int a = Math.abs(nums[i]);
            if (a <= L){
                // ����Ӿ���ֵ ����Ϊ�������ظ�����
                nums[ a-1 ] = - Math.abs(nums[a-1]);
            }
        }
        for (int i = 0; i < L; i++) {
            if (nums[i]>0){
                return i+1;
            }
        }
        return L+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,6,3,5,4};
        int i = solution.firstMissingPositive(nums);
        System.out.println(i);

    }
}
