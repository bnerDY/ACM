package problems;

import problems.ADT.TreeNode;

/**
 * Created by Martin on 14/03/2016.
 */
public class maximumDepthOfBinaryTree {

    /**
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     */

    public static int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        res = dfs(root, res);
        return res + 1;

    }

    public static int dfs(TreeNode n, int count) {
        int leftDepth = count, rightDepth = count;
        if (n.left != null) {
            leftDepth = dfs(n.left, count + 1);
        }
        if (n.right != null) {
            rightDepth = dfs(n.right, count + 1);
        }
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(maxDepth(root));

    }
}
