package problems;

/**
 * Created by Martin on 15/06/2015.
 */
public class symmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        // Problem 101. recursive.
        if(root == null){
            return true;
        }
        return isSymmetricTree(root.left, root.right);
    }

    public static boolean isSymmetricTree(TreeNode p, TreeNode q) {
        // Problem 101.
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root));

    }
}
