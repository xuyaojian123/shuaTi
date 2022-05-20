package xyj.字符串的排列567;

import java.security.cert.TrustAnchor;
import java.util.Arrays;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int L2 = s2.length();
        int L1 = s1.length();
        for (int i = 0; i < L2 - L1 + 1; i++) {
            String b = s2.substring(i,i+L1);
            if( check(s1,b) ){
                return true;
            }
        }
        return false;
    }

    //判断两个字符串是否相等（aabc == baac）元素一样就行
    public boolean check(String a , String b){
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        char[] chars1 = b.toCharArray();
        Arrays.sort(chars1);
        for (int i = 0; i < chars.length; i++) {
            if( chars[i]!=chars1[i] ){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        Solution solution = new Solution();
        boolean b = solution.checkInclusion(s1, s2);
        System.out.println(b);
    }
}