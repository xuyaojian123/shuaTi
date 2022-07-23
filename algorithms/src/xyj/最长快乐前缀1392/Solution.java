package xyj.最长快乐前缀1392;

import java.util.Arrays;


// KMP算法中的next数组
public class Solution {

    // 版本一next数组：next[i] = k，表示s[0:i]包括i的最长公共前后缀长度为k，next[0]=0
    public int[] next(String s) {
        int L = s.length();
        int[] next = new int[L];
        int k = 0, i = 1;
        while (i < L) {
            if (s.charAt(i) == s.charAt(k)) {
                next[i++] = ++k;
            } else {
                if (k == 0) {
                    next[i++] = 0;
                }else {
                    k = next[--k];
                }
            }
        }
        return next;
    }

    // 版本二next数组：next[i] = k，表示s[0:i-1]包括i-1的最长公共前后缀长度为k,next[0]=-1,next[1]=0
    public  int[] getNext(String ps) {
        int[] next = new int[ps.length()];
        next[0] = -1;next[1] = 0;
        int k = 0;
        int i = 1;
        while (i < ps.length() - 1){
            if (k == -1 ||  ps.charAt(i) == ps.charAt(k) ){
                next[++i] = ++k;
            }else {
                k = next[k];
            }
        }
        //char[] p = ps.toCharArray();
        //int[] next = new int[p.length];
        //next[0] = -1;
        //int j = 0;
        //int k = -1;
        //while (j < p.length - 1) {
        //    if (k == -1 || p[j] == p[k]) {
        //        next[++j] = ++k;
        //    } else {
        //        k = next[k];
        //    }
        //}
        return next;
    }

    //next数组版本三，对版本二的优化
    public  int[] getNext3(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[j] == p[k]) {
                if (p[++j] == p[++k]) { // 当两个字符相等时要跳过
                    next[j] = next[k];
                } else {
                    next[j] = k;
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }



    public String longestPrefix(String s) {
        int[] next = next(s);
        int L = s.length();
        int max = next[L-1];
        return s.substring(0,max);
    }

    public int KMP1(String a, String b){
        int[] next = next(b);
        int i=0,j=0;
        while (i<a.length() && j<b.length()){
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else {
                if (j==0){
                    i++;
                }else {
                    j = next[j-1];
                }
            }
        }
        if (j == b.length()){
            return i-j;
        }else {
            return -1;
        }
    }


    public int KMP2(String a, String b){
        int[] next = getNext(b);
        int i=0,j=0;
        while (i<a.length() && j<b.length()){
            if (j==-1 || a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            }else {
               j = next[j];
            }
        }
        if (j == b.length()){
            return i-j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "aacecaaaacecaa";
        int[] next = solution.next(str);
        //int[] next = solution.getNext(str);
        //int[] next3 = solution.getNext3(str);
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]+" ");
        }

        //String ababab = solution.longestPrefix("levet");
        //System.out.println(ababab);
    }
}
