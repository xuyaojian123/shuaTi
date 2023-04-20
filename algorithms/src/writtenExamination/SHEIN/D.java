package writtenExamination.SHEIN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {

    public static String getMaxSubStr2(String s) {
        int length = s.length();
        int i = 0;
        int j = 1;
        // ´æ´¢×î³¤×Ó´®
        String subStr = "";
        while (i < length && j < length) {
            if (s.substring(i, j).contains(Character.toString(s.charAt(j)))) {
                if (s.substring(i, j).length() > subStr.length()) {
                    subStr = s.substring(i, j);
                }
                i++;
            } else {
                j++;
            }
        }
        if (s.substring(i, j).length() > subStr.length()) {
            subStr = s.substring(i, j);
        }
        i = 0;
        j = 1;
        int k = subStr.length();
        while (i < length && j < length) {
            if (s.substring(i, j).contains(Character.toString(s.charAt(j)))) {
                if (s.substring(i, j).length() == k) {
                    System.out.println(s.substring(i, j));
                }
                i++;
            } else {
                j++;
            }
        }
        if (s.substring(i, j).length() == k) {
            System.out.println(s.substring(i, j));
        }
        return subStr;
    }

    public static void main(String[] args) {
        String s = "abcdabcd";
        String maxSubStr2 = getMaxSubStr2(s);
        System.out.println(maxSubStr2);
    }
}
