package problems;

import problems.ADT.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 05/04/2016.
 */
public class binaryTreePostOrderTraversal {
    static List<Integer> res = new ArrayList<>();

    public static List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root != null) {
            traversal(root);
        }

        return res;
    }

    public static void traversal(TreeNode p) {
        if (p.left != null)
            traversal(p.left);

        if (p.right != null)
            traversal(p.right);
        res.add(p.val);
    }

}
