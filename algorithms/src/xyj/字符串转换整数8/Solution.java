package xyj.×Ö·û´®×ª»»ÕûÊý8;

public class Solution {
    public int myAtoi(String s) {
        if (s.length()==0){
            return 0;
        }
        int L = s.length();
        int i = 0;
        while (i<L && s.charAt(i)==' '){
            i++;
        }
        if (i==L){
            return 0;
        }
        long result = 0;
        int flag = 1;
        if (s.charAt(i) == '+'){
            flag = 1;
        }else if (s.charAt(i)=='-'){
            flag = -1;
        }else if (s.charAt(i)>='0' && s.charAt(i)<='9'){
            result = s.charAt(i) - '0';
        }else {
            return 0;
        }
        for (int j = i+1; j < L; j++) {
            if (s.charAt(j)>='0' && s.charAt(j)<='9'){
                result = (result*10 + (s.charAt(j) - '0'));
                if ((result*flag) >= Integer.MAX_VALUE ){
                    return Integer.MAX_VALUE;
                }else if ((result*flag) <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else {
                break;
            }
        }
        return (int) (result*flag);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String  s = "  -42";
        int i = solution.myAtoi(s);
        System.out.println(i);
    }
}
