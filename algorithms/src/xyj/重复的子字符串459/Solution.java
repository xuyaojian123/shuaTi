package xyj.ÖØ¸´µÄ×Ó×Ö·û´®459;

public class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int[] next = next(s);
        String a = s.substring(next[next.length-1]);
        int L = a.length();
        String b = s.substring(0,L);
        if(next[next.length-1]==0){
            return false;
        }
        if (a.equals(b)){
            return true;
        }else {
            return false;
        }
    }

    private int[] next(String s){
        int[] next = new int[s.length()];
        next[0] = 0;
        int i = 1, k=0;
        while ( i< s.length() ){
            if ( s.charAt(i) == s.charAt(k)  ){
                next[i++] = ++k;
            }else {
                if (k == 0){
                    next[i++] = 0;
                }else {
                    k = next[k-1];
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {

    }
}
