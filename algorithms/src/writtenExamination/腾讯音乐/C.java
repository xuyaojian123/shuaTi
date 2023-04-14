package writtenExamination.ÌÚÑ¶ÒôÀÖ;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ĞìÒ«½¨
 * @date 2023/4/13 19:48
 * @Desc
 */
public class C {

    public static void main(String[] args) {
        C c = new C();
        int[] fun = c.fun(3);
        for (int i = 0; i < fun.length; i++) {
            System.out.print(fun[i] + " ");
        }

    }

    public int[] fun (int n) {
        int sum = (n * (n+1)) / 2;
        int[] result = new int[sum];
        //List<List<Integer>> temp = new ArrayList<>();
        //for (int i = 1; i <= n; i++) {
        //    List<Integer> skt = new ArrayList<>();
        //    for (int j = 0; j < i; j++) {
        //        skt.add(i);
        //    }
        //    temp.add(skt);
        //}
        int flag = n;
        int pos = 0;
        for (int i = n; i >= 1 ; i--) {
            for (int j = n; j > (n - flag) ; j--) {
                result[pos++] = j;
            }
            flag--;
        }
        return result;
        // write code here
    }
}
