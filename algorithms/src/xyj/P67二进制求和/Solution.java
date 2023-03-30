package xyj.P67二进制求和;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "11", b = "1";
        String s = solution.addBinary(a, b);
        System.out.println(s);

    }


    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        if (lena < lenb){
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = lena; i < lenb; i++) {
                aBuilder.insert(0, "0");
            }
            a = aBuilder.toString();
        }else {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = lenb; i < lena; i++) {
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        }
        char[] charsa = a.toCharArray();
        char[] charsb = b.toCharArray();
        StringBuilder result = new StringBuilder();
        int flag = 0;
        int i = charsa.length-1;
        int j = charsb.length-1;
        while (i>=0 && j>=0){
            int t = (charsa[i] - '0') + (charsb[i] - '0') + flag;
            if (t == 3){
                result.insert(0, "1");
                flag = 1;
            }else if (t == 2){
                result.insert(0, "0");
                flag = 1;
            }else if (t == 1){
                result.insert(0, "1");
                flag = 0;
            }else if (t == 0){
                result.insert(0, "0");
                flag = 0;
            }else {
                System.out.println("aaaa");
            }
            i--;
            j--;
        }
        if (flag==1){
            result.insert(0,"1");
        }
        return result.toString();
    }
}
