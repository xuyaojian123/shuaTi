package xyj.�ҵ��ַ�����������ĸ��λ��438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
        ����: s = "cbaebabacd", p = "abc"
        ���: [0,6]
        ����:
        ��ʼ�������� 0 ���Ӵ��� "cba", ���� "abc" ����λ�ʡ�
        ��ʼ�������� 6 ���Ӵ��� "bac", ���� "abc" ����λ�ʡ�

        ��Դ�����ۣ�LeetCode��
        ���ӣ�https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
        ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
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
            // ��С��߽�
            while ( right - left >= p.length() ) {
                // �ж��Ƿ�����С�ĳ����ִ�
                if (vaild == size){
                    result.add(left);
                }
                //��С��߽�
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
