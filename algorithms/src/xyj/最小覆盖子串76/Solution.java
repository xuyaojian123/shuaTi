package xyj.最小覆盖子串76;

import java.util.HashMap;
import java.util.Map;

// 解题思路：滑动窗口解决
/*
    输入：s = "ADOBECODEBANC", t = "ABC"
    输出："BANC"
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int left = 0, right = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int L = s.length();
        int vaild = 0;
        int size = need.size();
        int MIN_Length = Integer.MAX_VALUE;
        int start = 0;
        while (right < L) {
            char c = s.charAt(right);
            right++;
            int num = window.getOrDefault(c, 0);
            window.put(c, num + 1);
            if (need.containsKey(c)) {
                if (need.get(c) == (num + 1)) {
                    vaild++;
                }
            }

            // 缩小左边界
            while (vaild == size) {
                // 判断是否是最小的长度字串
                if (right - left < MIN_Length) {
                    start = left;
                    MIN_Length = right - left;
                }
                //缩小左边界
                char c1 = s.charAt(left);
                left++;
                int ans = window.get(c1);
                ans--;
                window.put(c1, ans);
                if (need.containsKey(c1)) {
                    if (ans < need.get(c1)) {
                        vaild--;
                    }
                }
            }

        }
        if (MIN_Length==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start,start+MIN_Length);
    }

    public static void main(String[] args) {
        String a = "aa", b = "aa";
        Solution solution = new Solution();
        String s = solution.minWindow(a, b);
        System.out.println(s);
    }
}
