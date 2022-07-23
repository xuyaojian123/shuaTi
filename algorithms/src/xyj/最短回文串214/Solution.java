package xyj.最短回文串214;

public class Solution {

    // 暴力
    public String shortestPalindrome1(String s) {
        String reverse = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            reverse = reverse + s.charAt(i);
        }
        int L = s.length();
        String palindrome = "";
        for (int i = 0; i < L; i++) {
            palindrome = reverse.substring(0,i) + s;
            Boolean flag = isPalindrome(palindrome);
            if (flag){
                break;
            }
        }
        return palindrome;
    }

    public Boolean isPalindrome(String str) {
        int len = str.length();
        int left = 0;
        int right = len - 1;
        boolean flg = true;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                flg = false;
                break;
            }
        }
        return flg;
    }

    public String shortestPalindrome(String s) {
        String reverse = "";
        for (int i = s.length()-1; i >=0 ; i--) {
            reverse = reverse + s.charAt(i);
        }
        reverse = s + "#" + reverse;
        int[] next = next(reverse);
        int L = next.length;
        int ans = next[L-1];
        String result = "";
        String temp = s.substring(ans);
        String temp_reverse = "";
        for (int i = temp.length()-1; i >=0; i--) {
            temp_reverse = temp_reverse + temp.charAt(i);
        }
        result = temp_reverse + s;
        return result;
    }

    public int[] next(String s) {
        int L = s.length();
        int[] next = new int[L];
        int k = 0, i = 1;
        while (i < L) {
            if (s.charAt(i) == s.charAt(k)) {
                next[i++] = ++k;
            } else {
                if (k == 0) {
                    next[i++] = 0;
                }else {
                    k = next[--k];
                }
            }
        }
        return next;
    }


    public static void main(String[] args) {

        Solution solution = new Solution();
        String str = "abcd";
        String s = solution.shortestPalindrome(str);
        System.out.println(s);

    }
}
