package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin on 10/02/2016.
 */

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * For example, given the following binary tree:
 * <p>
 * 1
 * / \
 * 2  3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * ["1->2->5", "1->3"]
 */
public class binaryTreePath {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, String.valueOf(root.val), res);
        return res;

    }

    public static void dfs(TreeNode n, String p, List<String> l) {
        if (n.left == null && n.right == null) {
            l.add(p);
        }
        if (n.left != null) {
            dfs(n.left, p + "->" + String.valueOf(n.left.val), l);
        }
        if (n.right != null) {
            dfs(n.right, p + "->" + String.valueOf(n.right.val), l);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(root));
    }
}
