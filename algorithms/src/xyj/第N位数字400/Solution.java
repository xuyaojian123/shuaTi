package xyj.��Nλ����400;

public class Solution {

    // ��ʱ
    //public int findNthDigit(int n) {
    //    String str = "";
    //    for (int i = 1; i <= n; i++) {
    //        str += String.valueOf(i);
    //    }
    //    return Integer.valueOf(str.charAt(n-1) - '0');
    //
    //}

    public int findNthDigit(int n) {
        long i=1,j=9;
        long sum = i*j;
        // ��һ�����ж�n���ڵڼ�λ��
        while (sum < n ){
            i++;
            j*=10;
            sum+=i*j;
        }
        // �ڶ������ж�n���ڼ�λ��������
        long ans = n - (sum - i*j)  - 1; //�±���㿪ʼ��0��10��100��1000��....
        long digit = (long)Math.pow(10,(i-1)) + ans/i ;
        // ������������������ĵڼ�λ
        long position = ans%i;
        String str = String.valueOf(digit);
        return Integer.valueOf( str.charAt((int) position)-'0' );
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNthDigit(10));
    }
}
