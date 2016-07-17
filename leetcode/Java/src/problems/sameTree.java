package problems;

import problems.ADT.TreeNode;

/**
 * Created by Martin on 10/02/2016.
 */
public class sameTree {

    /**
     * Given two binary trees, write a function to check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     *
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Problem 100. recursive.
        if (p == null && q == null) return true;
        if ((p != null && q == null) || (p == null && q != null)) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
}
