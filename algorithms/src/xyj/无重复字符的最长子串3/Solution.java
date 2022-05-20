package xyj.���ظ��ַ�����Ӵ�3;


import java.util.HashMap;
import java.util.Map;

/*
        ����: s = "abcabcbb"
        ���: 3
        ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
 */
public class Solution {

    //public int lengthOfLongestSubstring(String s) {
    //
    //}

    public int lengthOfLongestSubstring_other(String s) {
        if (s.equals("")){
            return 0;
        }
        int L = s.length();
        Map<Character, Integer> flag = new HashMap<>();
        int left = 0,right = 0,MAX_Len = -1;
        while ( right < L ){
            if (flag.containsKey(s.charAt(right))){
                flag.remove(s.charAt(left));
                left++;
            }else{
                flag.put(s.charAt(right),1);
                right++;
                if( right - left > MAX_Len ){
                    MAX_Len = right - left;
                }
            }
        }
        return MAX_Len;
    }


    public static void main(String[] args) {
        String s = "a";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring_other(s);
        System.out.println(i);
    }
}
