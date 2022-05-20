package xyj.最长回文子串5;

/**
 * 方法一：中心定理扩散 L = 2*Len + 1
 * 方法二： 动态规划 f[i][j],字符串s[i:j]是否为回文字串（true or false）
 */
public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1){
            return s;
        }
        Boolean[][] f = new Boolean[s.length()][s.length()];
        char[] s_chars = s.toCharArray();
        int L = s.length();
        int Max_len = -1;
        String result = "";
        for (int j = 0; j < L; j++) {
            f[j][j] = true;//一个元素肯定为回文
            for (int i = 0; i < j; i++) {
                if(j - i >=2 && f[i+1][j-1] && s_chars[i] == s_chars[j]){
                    f[i][j] = true;
                }else if(j==i+1 && s_chars[i] == s_chars[j]){
                    f[i][j] = true;
                }else{
                    f[i][j] = false;
                }
                if(f[i][j]){
                    if(j - i > Max_len){
                        Max_len = j - i;
                        result = String.valueOf(s_chars).substring(i,j+1);
                    }
                }
            }
        }
        //for (int i = 0; i < L; i++) {
        //    for (int j = 0; j < L; j++) {
        //        System.out.print(f[i][j]+" ");
        //    }
        //    System.out.println();
        //}
        if(Max_len == -1){
            return s.substring(0,1);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "bb";
        Solution solution = new Solution();
        String s = solution.longestPalindrome(str);
        System.out.println(s);
    }
}
