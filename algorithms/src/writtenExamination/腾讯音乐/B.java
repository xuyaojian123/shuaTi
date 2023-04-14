package writtenExamination.腾讯音乐;

//小红的二叉树
//小红拿到了一颗二叉树，定义每个节点的价值为子树节点乘积的末尾0的数量。现在请你返回一颗二叉树，树的结构和给定二叉树相同，将每个节点的权值替换为该节点的价值。
//
//二叉树的节点不超过10^5。
//
//二叉树每个节点的权值都是不超过10^9的正整数。
//示例1
//
//输入
//
//{2,5,10,#,#,4,5}
//输出
//
//{3,0,2,#,#,0,0}
//说明
//
//小红拿到的树
//                       2
//                     /   \
//                    5     10
//                         /  \
//                        4    5
//需要返回的树
//        3
//       /  \
//      0    2
//          / \
//         0   0

//思路与代码
//
//这个题本身就是一个二叉树的遍历而已，没有什么特别的，但是每个数的规模很大，不能直接相乘获取末尾0。
// 因此需要观察一个规律，不难发现，末尾0的数量取决于该数字的2和5的因子的最小值，因此我们遍历树的时候向上返回以当前节点为根的子树的2和5的因子数量即可。
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
