package xyj.������ʽƥ��10;

public class Solution {

    public boolean isMatch(String s, String p) {
        // dp[i][j]����p��ǰi���ַ���s��ǰj���ַ��ܷ�ƥ��
        int m = s.length(),n = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0]= true;
        for (int i = 1; i < n+1; i++) {
            if(p.charAt(i) == '*'){
                if (i - 2 >=0){
                    dp[i][0] = dp[i - 2][0]; // ���԰�p��*�ź�ǰ����ַ�һ��ȥ��
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m+1; j++) {
                // ���������
                if ( p.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else if (p.charAt(i)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if( p.charAt(i)=='*'){
                    // p��ǰһ���ַ����ܹ�ƥ�䵽s�ĵ�ǰ�ַ����߲�ȥƥ�䣬����ѡ��(ɾ��ǰ����ַ���*�ţ�Ҳ����i-2)
                    dp[i][j] = dp[i-2][j];
                    // ���p��ǰһ���ַ��ܹ�ƥ�䵽s�ĵ�ǰ�ַ�
                    // (���ƥ��Ļ�������Ҫʹ����ȫ�������Ż���˼�롣��Ϊ������������������ֻ���ǵ�ǰ���j��ƥ��������)
                    if (p.charAt(i-1)==s.charAt(j) || p.charAt(i-1) =='.'){
                        dp[i][j] = dp[i][j-1] || dp[i][j]; // ����Ҫ�û򣬶�Ӧǰ������ѡ��
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = "aaa";
        String b = "ab*a*c*a";
        boolean match = solution.isMatch(a, b);
        System.out.println(match);
    }
}
