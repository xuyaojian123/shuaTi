package xyj.»ØÎÄÊý9;

public class Solution {

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int L = s.length();
        int left= 0,right = 0;
        if (L%2==0){
            left = (L / 2) - 1;
            right = (L / 2);
        }else {
            left=right=L/2;
        }
        while (left >=0 ){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(-121);
    }
}
