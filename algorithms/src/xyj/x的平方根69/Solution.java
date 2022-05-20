package xyj.x的平方根69;

public class Solution {
    public int mySqrt(int x) {
        int left = 0,right = x;
        if(x == 0){
            return 0;
        }
        if (x==1){
            return 1;
        }
        while( (right-left) != 1 ){
            int mid = left + (right - left) /2;
            if( (long) mid*mid > x ){
                right = mid;
            }else if( mid*mid <= x ){
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }
}
