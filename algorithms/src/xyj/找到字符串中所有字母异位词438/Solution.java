package xyj.找到字符串中所有字母异位词438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
        输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]
        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()){
            return result;
        }
        int left = 0, right = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int L = s.length(), vaild = 0, size = need.size();
        while (right < L) {
            char c = s.charAt(right);
            right++;
            int num = window.getOrDefault(c, 0);
            if (need.containsKey(c)) {
                window.put(c, num + 1);
                if (need.get(c) == (num + 1)) {
                    vaild++;
                }
            }
            // 缩小左边界
            while ( right - left >= p.length() ) {
                // 判断是否是最小的长度字串
                if (vaild == size){
                    result.add(left);
                }
                //缩小左边界
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    int ans = window.get(c1);
                    window.put(c1, ans - 1 );
                    if ( ans ==  need.get(c1)) {
                        vaild--;
                    }
                }

            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        Solution solution = new Solution();
        List<Integer> anagrams = solution.findAnagrams(s, p);
        System.out.println(anagrams);

    }
}
