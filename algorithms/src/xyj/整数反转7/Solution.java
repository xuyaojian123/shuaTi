package xyj.整数反转7;

public class Solution {

    public int reverse(int x) {
        String s = String.valueOf(x);
        char[] digits = s.toCharArray();
        int L = digits.length;
        int flag = 0;
        int ans = digits.length - 1;
        for (int i = digits.length - 1; i >= 1 ; i--) {
            if (digits[i]=='0'){
                ans--;
            }else {
                break;
            }
        }
        long reverse = 0;
        for (int i = ans; i >= 1 ; i--) {
            reverse = reverse*10 + (digits[i] - '0');
        }
        if (digits[0]=='-'){
            reverse = reverse*-1;
        }else{
            reverse = reverse*10 + (digits[0] - '0');
        }
        if (reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE){
            reverse = 0;
        }
        return  (int) reverse;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse = solution.reverse(-120);
        System.out.println(reverse);
    }
}
