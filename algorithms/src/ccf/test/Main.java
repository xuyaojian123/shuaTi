package ccf.test;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        String s = stringStringHashMap.get("11");
        if (s==null){
            System.out.println("nulll");
        }
        System.out.println(s);
    }
}
