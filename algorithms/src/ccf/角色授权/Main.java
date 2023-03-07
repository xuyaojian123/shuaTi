package ccf.角色授权;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n,m,q; // 角色数量、角色关联数量和待检查的操作数量
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        HashMap<String, List<Set<String>>> juese = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String jueseName = scanner.next();
            ArrayList<Set<String>> total = new ArrayList<>();
            int nv = scanner.nextInt();
            Set<String> opts = new HashSet<>();
            for (int j = 0; j < nv; j++) {
                opts.add(scanner.next());
            }
            int no = scanner.nextInt();
            Set<String> resources = new HashSet<>();
            for (int j = 0; j < no; j++) {
                resources.add(scanner.next());
            }
            int nn = scanner.nextInt();
            Set<String> type = new HashSet<>();
            for (int j = 0; j < nn; j++) {
                    type.add(scanner.next());
            }
            total.add(opts);
            total.add(resources);
            total.add(type);
            juese.put(jueseName,total);
        }
        Map<String, Set<String>> connection_usertojuese = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String name = scanner.next();
            int a = scanner.nextInt();
            for (int j = 0; j < a; j++) {
                String c = scanner.next();
                String d = scanner.next();
                if (connection_usertojuese.containsKey(d)){
                    connection_usertojuese.get(d).add(name);
                }else {
                    Set<String> pp = new HashSet<String>();
                    pp.add(name);
                    connection_usertojuese.put(d,pp);
                }
            }
        }
        for (int i = 0; i < q; i++) {
            String name = scanner.next();
            int i1 = scanner.nextInt();
            List<String> lie = new ArrayList<>();
            lie.add(name);
            for (int j = 0; j < i1; j++) {
                String i2 = scanner.next();
                lie.add(i2);
            }
            String action = scanner.next();
            String type = scanner.next();
            String resource_name = scanner.next();
            int flag = 0;
            for (int j = 0; j < lie.size(); j++) {
                Set<String> temp_juese = connection_usertojuese.get(lie.get(j));
                if (temp_juese!=null){
                    for (String jj:temp_juese) {
                        List<Set<String>> sets = juese.get(jj);
                        Set<String> strings1 = sets.get(0);
                        Set<String> strings2 = sets.get(1);
                        Set<String> strings3 = sets.get(2);
                        if ( (strings1.contains(action) || strings1.contains("*")) &&  (strings2.contains(type) || strings2.contains("*"))
                                && ( strings3.isEmpty() ||  strings3.contains(resource_name))){
                            flag = 1;
                            break;
                        }
                    }
                }
                if (flag==1){
                    break;
                }
            }
            if (flag == 1){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }
    }
}
