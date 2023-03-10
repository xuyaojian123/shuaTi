package xyj.最后一个单词的长度56;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "   fly me   to   the moon  ";
        int i = solution.lengthOfLastWord(s);

    }

    public int lengthOfLastWord(String s) {
        String[] s1 = s.split("\\s+");
        String s2 = s1[s1.length - 1];
        return s2.length();
    }
}
