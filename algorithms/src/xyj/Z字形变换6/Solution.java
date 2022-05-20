package xyj.Z字形变换6;


// 模拟题
public class Solution {


    // 找规律
    public String convert(String s, int numRows) {
        int L = s.length();
        int key = 2*numRows - 2;
        if (key == 0){
            key = 1;
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            int ans = i;
            if (i==0 || i==numRows-1){
                while (true){
                    if(ans>=L){
                        break;
                    }
                    result+=s.charAt(ans);
                    ans = ans + key;
                }
            }else {
                while (true){
                    int after = ans + key - 2 * i;
                    if (ans >= L){
                        break;
                    }else if (ans < L && after >= L ){
                        result += s.charAt(ans);
                        break;
                    }else if (ans < L && after < L){
                        result+= s.charAt(ans);
                        result+= s.charAt(after);
                    }
                    ans = ans + key;
                }
            }
        }
        return result;
    }
    // 模拟-超时了
    public String convert1(String s, int numRows) {
        int m = numRows;//行
        int n = m-2 + 2;//列
        String[] map = new String[numRows];
        for (int i = 0; i < m; i++) {
            map[i] = "";
        }
        int L  = m*2 + m-2;
        int begin = 0;
        int t = s.length();
        while (begin < t){
            int end =  begin + L + m - 2;
            if (end > t){
                end = t;
            }
            String substring = s.substring(begin, end);
            int flag = substring.length();
            for (int i =0 ;i<numRows;i++){
                if( i >= flag){
                    break;
                }
                map[i]+= substring.charAt(i);
            }
            int ans = m;
            for (int i = numRows-2; i >0 ; i--) {
                if( ans >= flag){
                    break;
                }
                map[i] += substring.charAt(ans);
                ans++;
            }
            for (int i = 0; i < numRows; i++) {
                if( ans >= flag){
                    break;
                }
                map[i] += substring.charAt(ans);
                ans++;
            }
            for (int i = numRows-2; i >0 ; i--) {
                if( ans >= flag){
                    break;
                }
                map[i] += substring.charAt(ans);
                ans++;
            }
            begin = begin +end;
        }
        String result = "";
        for (int i = 0; i < m; i++) {
            result+=map[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ABC";
        int numRows = 3;
        String convert = solution.convert(s, numRows);
        System.out.println(convert);
    }
}
