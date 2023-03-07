package xyj.字母异位词分组49;



import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[6];
        strings[0] = "eat";
        strings[1] = "tea";
        strings[2] = "tan";
        strings[3] = "ate";
        strings[4] = "nat";
        strings[5] = "bat";
        List<List<String>> lists = solution.groupAnagrams(strings);
        int t = 1;


    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[] flags = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            if (flags[i]==0){
                List<String> one = new ArrayList<>();
                one.add(str);
                for (int j = i+1; j < strs.length; j++) {
                    if (flags[j]==0){
                        if ( checkEqual(str,strs[j])) {
                            one.add(strs[j]);
                            flags[j]=1;
                        }
                    }
                }
                result.add(one);
            }
            flags[i] = 1;
        }
        return result;
    }

    public boolean checkEqual(String a, String b){
        // 排序的方式比map的get和set快
        if (a.length()!=b.length()){
            return false;
        }
        char[] array1 = a.toCharArray();
        Arrays.sort(array1);
        char[] array2 = b.toCharArray();
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i]!=array2[i]){
                return false;
            }
        }
        return true;
        //if (a.length()!=b.length()){
        //    return false;
        //}
        //HashMap<Character, Integer> map1 = new HashMap<>();
        //HashMap<Character, Integer> map2 = new HashMap<>();
        //for (int i = 0; i < a.length(); i++) {
        //    map1.put(a.charAt(i),map1.getOrDefault(a.charAt(i),0)+1);
        //}
        //for (int i = 0; i < b.length(); i++) {
        //    map2.put(b.charAt(i),map2.getOrDefault(b.charAt(i),0)+1);
        //}
        //Set<Character> keys = map1.keySet();
        //for (Character next : keys) {
        //    if (!map2.containsKey(next) || map2.get(next) != map1.get(next)) {
        //        return false;
        //    }
        //}
        //return true;
    }
}
