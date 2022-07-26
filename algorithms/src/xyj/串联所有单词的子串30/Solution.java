package xyj.串联所有单词的子串30;

import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();
        int word_num = words.length;
        int all_len = one_word * word_num;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - all_len + 1; i++) {
            String tmp = s.substring(i, i + all_len);
            HashMap<String, Integer> temp_map = new HashMap<>();
            for (int j = 0; j < all_len; j += one_word) {
                String w = tmp.substring(j, j + one_word);
                temp_map.put(w, temp_map.getOrDefault(w, 0) + 1);
            }
            if (map.equals(temp_map)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = new String[2];
        String s = "barfoothefoobarman";
        words[0] = "foo";
        words[1] = "bar";
        solution.findSubstring(s,words);

    }
}
