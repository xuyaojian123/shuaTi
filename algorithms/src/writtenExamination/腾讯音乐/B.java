package writtenExamination.��Ѷ����;

//С��Ķ�����
//С���õ���һ�Ŷ�����������ÿ���ڵ�ļ�ֵΪ�����ڵ�˻���ĩβ0���������������㷵��һ�Ŷ����������Ľṹ�͸�����������ͬ����ÿ���ڵ��Ȩֵ�滻Ϊ�ýڵ�ļ�ֵ��
//
//�������Ľڵ㲻����10^5��
//
//������ÿ���ڵ��Ȩֵ���ǲ�����10^9����������
//ʾ��1
//
//����
//
//{2,5,10,#,#,4,5}
//���
//
//{3,0,2,#,#,0,0}
//˵��
//
//С���õ�����
//                       2
//                     /   \
//                    5     10
//                         /  \
//                        4    5
//��Ҫ���ص���
//        3
//       /  \
//      0    2
//          / \
//         0   0

//˼·�����
//
//����Ȿ�����һ���������ı������ѣ�û��ʲô�ر�ģ�����ÿ�����Ĺ�ģ�ܴ󣬲���ֱ����˻�ȡĩβ0��
// �����Ҫ�۲�һ�����ɣ����ѷ��֣�ĩβ0������ȡ���ڸ����ֵ�2��5�����ӵ���Сֵ��������Ǳ�������ʱ�����Ϸ����Ե�ǰ�ڵ�Ϊ����������2��5�������������ɡ�
public class B {

    public static void main(String[] args) {
        B b = new B();
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(10);
        root.left = node1;
        root.right = node2;
        TreeNode tree = b.getTree(root);
        int t = 1;
        //b.postOrder()
    }

    private int[] counts(int n) {
        int count_2 = 0;
        int count_5 = 0;
        while (n % 2 == 0) {
            count_2++;
            n /= 2;
        }
        while (n % 5 == 0) {
            count_5++;
            n /= 5;
        }
        return new int[]{count_2, count_5};
    }

    public TreeNode getTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};
        int[] cur = counts(node.val);
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        cur[0] += l[0] + r[0];
        cur[1] += l[1] + r[1];
        node.val = Math.min(cur[0], cur[1]);
        return cur;
    }
}
